package ru.javacourse.sourcecodebot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.javacourse.sourcecodebot.telegram.ServiceBot;

import javax.annotation.PostConstruct;

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
        return new ServiceBot();
    }
}
