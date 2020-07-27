package ru.javacourse.sourcecodebot.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javacourse.sourcecodebot.model.User;
import ru.javacourse.sourcecodebot.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Transactional
public class ServiceBot extends TelegramLongPollingBot {

    private static final String UNKNOWN_COMMAND = "Неизвестная команда";
    private static final String BLOCKED_STATUS_COMMAND = "YOU SHALL NOT PASS!!!";

    private final Map<String, MessageHandler> handlers;

    public ServiceBot(Map<String, MessageHandler> handlers) {
        this.handlers = handlers;
    }

    @Autowired
    private UserRepository userRepository;

    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {

        if(checkUserByIDAndUpdate(update)) {
            String userMessage = update.getMessage().getText();

        for (String key: handlers.keySet()) {
            if (userMessage.contains(key)) {
                try {
                    MessageHandler handler = handlers.get(key);
                    if (handler != null) {
                        execute(handler.handle(update));
                    } else {
                        sendDefaultMessage(update);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        } else {
            try {
                sendBlockedMessage(update);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public boolean checkUserByIDAndUpdate (Update update){
        Optional<User> optUser = userRepository.findById(update.getMessage().getChatId());
        if(optUser.isEmpty()){
            User user = new User();
            user.setUserId(update.getMessage().getChatId());
            user.setFirstName(update.getMessage().getChat().getFirstName());
            user.setUserName(update.getMessage().getChat().getUserName());
            user.setLastName(update.getMessage().getChat().getLastName());
            user.setBlocked(false);
            user.setLastActiveDate(LocalDateTime.now());
            userRepository.save(user);
        }else{
            optUser.get().setLastActiveDate(LocalDateTime.now());
            userRepository.save(optUser.get());
            return !optUser.get().isBlocked();
        }
        return true;
    }

    private void sendDefaultMessage(Update update) throws Exception {
        SendMessage msg = new SendMessage();
        msg.enableMarkdown(true);
        msg.setChatId(update.getMessage().getChatId());
        msg.setText(UNKNOWN_COMMAND);
        execute(msg);
    }

    private void sendBlockedMessage(Update update) throws Exception {
        SendMessage msg = new SendMessage();
        msg.enableMarkdown(true);
        msg.setChatId(update.getMessage().getChatId());
        msg.setText(BLOCKED_STATUS_COMMAND);
        execute(msg);
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     *
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "SourceCodeSchoolbot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     *
     * @return token для бота
     * <p>
     * TODO: спрятать токен
     */
    @Override
    public String getBotToken() {
        return "866667038:AAF-59KcmNLo66Qk6KlTRcporb9UUVYjWj0";
    }
}
