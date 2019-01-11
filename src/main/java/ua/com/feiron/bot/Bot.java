package ua.com.feiron.bot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by f on 27.11.2017.
 */
public class Bot extends TelegramLongPollingBot {
    private static final Logger LOGGER = Logger.getLogger(Bot.class.getName());

    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/help")) {
                sendMsg(message, "Это тестовый режим Feiron Бота. Подписывайтесь на наш telegram - канал. Вскором времени" +
                        " Бот заработает в функциональном режиме. У Вас появится возмоность: " +
                        "1)Ознакомиться с ассортиментом нашей продукции; " +
                        "2)Узнать о наличии металла; " +
                        "3)Узнать стоимость на текущий момент времени; " +
                        "4)Получить ответы на многие вопросы, связанные с кровлей. И еще много интересного... . " +
                        "До скорой встречи! С Ув., FEIRON Bot");
            }
            else if (message.getText().equalsIgnoreCase("профнастил")) {
                sendMsg(message, "Какой? У нас имеется: 'С10', 'С20', 'С35', 'С44', 'С60', 'С75' 'url'");

            }else if (message.getText().equalsIgnoreCase("профнастил")) {
                sendMsg(message, "Какой? У нас имеется: 'С10', 'С20', 'С35', 'С44', 'С60', 'С75' 'url'");
            }
            else if (message.getText().equalsIgnoreCase("С10")) {
                sendMsg(message, "98 грн.");
            }
            else sendMsg(message, "Компания Feiron приветствует Вас, для помощи введите '/help'");
        }

    }




    private void sendMsg(Message message, String s) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        LOGGER.info(message);
        LOGGER.info(message.getText());
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "FEIRON";
    }

    @Override
    public String getBotToken() {
        return "489139697:AAG6b0riMSX1RQgFTvk0jEelivH6vW91TSI";
    }
}
