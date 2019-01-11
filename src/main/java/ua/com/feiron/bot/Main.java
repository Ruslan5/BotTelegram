package ua.com.feiron.bot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.net.MalformedURLException;
import java.util.Scanner;

/**
 * Created by f on 14.12.2017.
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) throws MalformedURLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Запуск");
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        LOGGER.getLogger(telegramBotsApi.toString());
        LOGGER.info(telegramBotsApi);


        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
