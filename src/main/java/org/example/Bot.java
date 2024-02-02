package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private MessageProcessing messageProcessing = new MessageProcessing();
    public Bot(String botToken) {
        super(botToken);
    }

    public String getBotUsername() {
        return "nelson2606_bot";
    }

    @Override
    public String getBotToken() {
        return "6782383888:AAFLC2yYS1J8w1Vqi2n4Uan78AYzJeIJpEM";
    }

    public void onUpdateReceived(Update update) {//запрос бот
        Message message = update.getMessage();
        if (message.hasText()){
            String text = message.getText();
            Long chatId = message.getChatId();//id того кто написал боту
            String userName = message.getFrom().getUserName();

            loggi(text, chatId, userName);
            String answer = messageProcessing.processing(text);
            if (answer != null){
                //-----------------------------------------------
                SendMessage sendMessageUser = new SendMessage();
                sendMessageUser.setChatId(chatId);
                sendMessageUser.setText(answer);

                try {
                    execute(sendMessageUser);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }

        } else if (message.hasAudio()) {

        }


    }

    private static void loggi(String text, Long chatId, String userName) {
        String green = "\u001B[32m";
        String reset = "\u001B[0m";

        System.out.print(green);
        System.out.print("Запрос");
        System.out.println(reset);

        System.out.println("-------------------");
        System.out.println("ID: " + chatId);
        System.out.println("userName: " + userName);
        System.out.println("text: " + text);
        System.out.println("-------------------");
    }


}
