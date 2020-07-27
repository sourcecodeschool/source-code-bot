package ru.javacourse.sourcecodebot.telegram.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javacourse.sourcecodebot.model.Resource;
import ru.javacourse.sourcecodebot.repository.ResourceRepository;
import ru.javacourse.sourcecodebot.telegram.MessageHandler;

import java.util.Map;

@Transactional
public class InterviewHandler implements MessageHandler {

    @Autowired
    private ResourceRepository repository;

    @Override
    public SendMessage handle(Update update) {
        String text = update.getMessage().getText();

        switch (text) {
            case "/java/interview/random": {
                return getRandomQuestion(update);
            }
            default: {
               return getRandomQuestionByTag(update);
            }
        }
    }

    public SendMessage getRandomQuestion(Update update) {

        Resource question = repository.findRandomQuestion("interview_question");

        String responseText;

        if (question == null) {
            responseText = "Данный запрос не найден";
        } else {
            responseText = question.getTitle();
        }

        SendMessage msg = new SendMessage();
        msg.enableMarkdown(true);
        msg.setChatId(update.getMessage().getChatId());
        msg.setText(responseText);
        return msg;
    }

    public SendMessage getRandomQuestionByTag(Update update) {
        String userMessage = update.getMessage().getText();
        String tag = userMessage.substring(userMessage.lastIndexOf("/") + 1);

        Resource question = repository.findRandomQuestionByTag("interview_question", tag);

        String responseText;

        if (question == null) {
            responseText = "Данный запрос не найден";
        } else {
            responseText = question.getTitle();
        }

        SendMessage msg = new SendMessage();
        msg.enableMarkdown(true);
        msg.setChatId(update.getMessage().getChatId());
        msg.setText(responseText);
        return msg;
    }
}
