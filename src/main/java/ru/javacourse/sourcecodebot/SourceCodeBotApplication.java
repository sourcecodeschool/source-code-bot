package ru.javacourse.sourcecodebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.javacourse.sourcecodebot.telegram.CommonBot;

@SpringBootApplication
public class SourceCodeBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourceCodeBotApplication.class, args);

		ApiContextInitializer.init(); // Инициализируем апи
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new CommonBot());
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}

}
