package ru.javacourse.sourcecodebot.telegram.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javacourse.sourcecodebot.model.Lesson;
import ru.javacourse.sourcecodebot.model.Resource;
import ru.javacourse.sourcecodebot.repository.LessonRepository;
import ru.javacourse.sourcecodebot.telegram.MessageHandler;

public class LessonHandler implements MessageHandler {

    @Autowired
    private LessonRepository repository;

    @Override
    public SendMessage handle(Update update) {
        Lesson lesson = repository.findLessonByChapterId("2.1");
        Resource resource = lesson.getResources();

        SendMessage msg = new SendMessage();
        msg.enableMarkdown(true);
        msg.setChatId(update.getMessage().getChatId());

        if (resource != null) {
            msg.setText(resource.getLink());
        } else {
            msg.setText("123");
        }
        return  msg;
    }
}
