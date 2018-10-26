package telegram;

import config.TelegramConfig;
import config.YamlConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import weather.ForecastObject;
import weather.WeatherRequest;
import weather.WheaterParser;

import java.util.List;


public class TelegramBot extends TelegramLongPollingBot {


    private final static Logger logger = LogManager.getLogger(TelegramBot.class);
    private String botName;
    private String botApi;
    private WeatherRequest weatherRequest;

    public TelegramBot(YamlConfig yamlConfig){

        this.botName = yamlConfig.getTelegram().getName();
        this.botApi= yamlConfig.getTelegram().getApi();
        this.weatherRequest = new WeatherRequest(yamlConfig.getOpenweathermap());


    }

    @Override
    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {

            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            logger.info("Received text message \""+message_text+"\" from chat_id \""+chat_id+"\"");

            SendMessage message = new SendMessage()
                    .setChatId(chat_id)
                    .setText(message_text);
            try {

                execute(message);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        // We check if the update has a location
        if(update.hasMessage() && update.getMessage().hasLocation()){

            Location location = update.getMessage().getLocation();
            logger.info("Received location \""+location.getLatitude()+","+location.getLongitude()+"\"");
            String forecastResult = weatherRequest.getForecastByGeoCoord(location.getLatitude(),location.getLongitude());
            List<ForecastObject> deserializedForecastObject = WheaterParser.deserialize(forecastResult);
            logger.info("result "+forecastResult);

            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(deserializedForecastObject.get(0).getCurrentWeatherDescription());
            try {

                execute(message);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        return this.botName;
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return this.botApi;
    }
}