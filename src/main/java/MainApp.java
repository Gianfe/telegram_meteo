import config.YamlConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.yaml.snakeyaml.Yaml;
import telegram.TelegramBot;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainApp {

    private final static Logger logger = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {

        logger.info("App starting....");

        //load configuration YAML

        Yaml yaml = new Yaml();
        YamlConfig config = null;

        try (InputStream in = Files.newInputStream(Paths.get("/home/gianfe/Documenti/java_workspace/meteo/src/main/resources/config.yaml"))) {

            config = yaml.loadAs(in, YamlConfig.class);
            logger.info("configuration loaded: "+config.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize Api Context
        ApiContextInitializer.init();

        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();

        // Register our bot
        try {
            botsApi.registerBot(new TelegramBot(config));
            logger.info("Telegram Bot up and running ");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
