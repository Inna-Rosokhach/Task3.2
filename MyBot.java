package org.example;

import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    public MyBot(){
        super("7242562600:AAHMyjH3b9Wvc1SDdA8VxzqUVtvGTuE8dIA");
    }
    @Override
    public void onUpdateReceived(Update update) {
        var chatId = update.getMessage().getChatId();
        var text = update.getMessage().getText().toLowerCase();

        try {
        var message = new SendMessage();
        message.setChatId(chatId);
            var priceBTC = CryptoPrice.spotPrice("BTC");
            var priceETH = CryptoPrice.spotPrice("ETH");
            var priceDOGE = CryptoPrice.spotPrice("DOGE");
            var price ="";

        if (text.equals("/start")){
            message.setText("Hello!");
        } else if (text.equals("btc")) {
            message.setText("BTC price: " +priceBTC.getAmount().doubleValue());
        } else if (text.equals("eth")) {
            message.setText("ETH price: " +priceETH.getAmount().doubleValue());
        } else if (text.equals("doge")) {
            message.setText("DOGE price: " +priceDOGE.getAmount().doubleValue());
        } else if (text.equals("/all")) {
            message.setText("BTC price: " +priceBTC.getAmount().doubleValue() + " ETH price: " +priceETH.getAmount().doubleValue() + " DOGE price: " +priceDOGE.getAmount().doubleValue());
        }
        else {
            message.setText("Unknown command!");
        }
                        execute(message);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    @Override
    public String getBotUsername() {
        return "CalculadorProg_bot";
    }
}
