package ru.javacourse.sourcecodebot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.javacourse.sourcecodebot.telegram.MessageHandler;
import ru.javacourse.sourcecodebot.telegram.ServiceBot;
import ru.javacourse.sourcecodebot.telegram.handlers.HelpHandler;
import ru.javacourse.sourcecodebot.telegram.handlers.InterviewHandler;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TelegramConfig {

    /**
     * Инициализируем API
     */
    @PostConstruct
    public void initApi() {
        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(createCommonBot());
        } catch (TelegramApiRequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public ServiceBot createCommonBot() {
        Map<String, MessageHandler> handlers = new HashMap<>();
        handlers.put("/help", helpHandler());
        handlers.put("/java/interview/", interviewHandler());
        return new ServiceBot(handlers);
    }

    @Bean
    public HelpHandler helpHandler() {
        return new HelpHandler();
    }

    @Bean
    public InterviewHandler interviewHandler() {
        return new InterviewHandler();
    }
}

