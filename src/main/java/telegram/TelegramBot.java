package telegram;

import com.vdurmont.emoji.EmojiParser;
import config.YamlConfig;
import mongo.MongoAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import weather.OpenWeatherParser;
import weather.WeatherObject;
import weather.WeatherRequest;


public class TelegramBot extends TelegramLongPollingBot {


    private final static Logger logger = LogManager.getLogger(TelegramBot.class);
    private String botName;
    private String botApi;
    private WeatherRequest weatherRequest;
    private MongoAdapter mongoAdapter;

    public TelegramBot(YamlConfig yamlConfig){

        this.botName = yamlConfig.getTelegram().getName();
        this.botApi= yamlConfig.getTelegram().getApi();
        this.weatherRequest = new WeatherRequest(yamlConfig.getOpenweathermap());
        this.mongoAdapter = new MongoAdapter(yamlConfig.getMongo().getUri(),yamlConfig.getMongo().getDatabase(),yamlConfig.getMongo().getUserCollection()) ;


    }

    @Override
    public void onUpdateReceived(Update update) {

        TelegramBotUser user;

        if(update.hasMessage()){

            user = new TelegramBotUser(update.getMessage().getChatId(),update.getMessage().getFrom());

            mongoAdapter.check(user);

            // We check if the update has a location
            if(update.getMessage().hasLocation()){

                Location location = update.getMessage().getLocation();
                logger.info("Received weatherRequest from location \""+location.getLatitude()+","+location.getLongitude()+"\" performed by \""+user.getFirstName()+"\"");
                String weatherResult = weatherRequest.getWeatherByGeoCoord(location.getLatitude(),location.getLongitude());
                WeatherObject weatherObject = OpenWeatherParser.deserializeWeather(weatherResult);

                logger.info("result "+weatherObject);

                SendMessage message = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText(weatherObject.getWeatherDescription());

                /*String answer = EmojiParser.parseToUnicode("Here is a smile emoji: :smile:\n\n Here is alien emoji: :alien:");
                SendMessage message1 = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText(answer);*/

                try {

                    execute(message);
                    //execute(message1);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }

        }



        // We check if the update has a message and the message has text
        /*if (update.hasMessage() && update.getMessage().hasText()) {

            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            User user = update.getMessage().getFrom();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String userName = user.getUserName();

            logger.info("firstName:\""+firstName+ "\" lastName:\""+lastName+"\" chat_id:\""+chat_id+"\"");
            logger.info("Received text message \""+message_text+"\"");

            SendMessage message = new SendMessage()
                    .setChatId(chat_id)
                    .setText(message_text);
            try {

                execute(message);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        */

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