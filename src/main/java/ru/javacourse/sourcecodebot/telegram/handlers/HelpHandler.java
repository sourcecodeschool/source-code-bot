package ru.javacourse.sourcecodebot.telegram.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javacourse.sourcecodebot.telegram.MessageHandler;

public class HelpHandler implements MessageHandler {

    @Override
    public SendMessage handle(Update update) {
        SendMessage msg = new SendMessage();

        msg.enableMarkdown(true);
        msg.setChatId(update.getMessage().getChatId());
        msg.setText("Документация находится в разработке");
        return msg;
    }
}
