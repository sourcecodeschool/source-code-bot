package ru.javacourse.sourcecodebot.telegram.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javacourse.sourcecodebot.model.Resource;
import ru.javacourse.sourcecodebot.repository.ResourceRepository;
import ru.javacourse.sourcecodebot.telegram.MessageHandler;

@Transactional
public class InterviewHandler implements MessageHandler {

    @Autowired
    private ResourceRepository repository;


    @Override
    public SendMessage handle(Update update) {
        Resource question = repository.findRandomQuestion("interview_question");

        SendMessage msg = new SendMessage();
        msg.enableMarkdown(true);
        msg.setChatId(update.getMessage().getChatId());
        msg.setText(question.getTitle());


        return msg;
    }
}
