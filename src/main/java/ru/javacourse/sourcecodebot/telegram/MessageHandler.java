package ru.javacourse.sourcecodebot.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 *  Обработчик пользовательских сообщений
 */
public interface MessageHandler {

    SendMessage handle(Update update);
}
