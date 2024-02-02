package org.example;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {
    public static void main( String[] args ) {
        String token = "6782383888:AAFLC2yYS1J8w1Vqi2n4Uan78AYzJeIJpEM";
        Bot bot = new Bot(token);

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);



        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }
}
