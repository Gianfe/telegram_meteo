import config.WeatherConfig;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import weather.WeatherRequest;
import weather.WheaterParser;

import java.io.File;
import java.io.IOException;

public class WheatherParserTestClass {

    @Test
    public void testWeatherParser() throws IOException {

        String wheatherString = FileUtils.readFileToString(new File("D:\\Profiles\\gmeloni\\Documents\\Sorgenti\\Varie\\meteo\\src\\main\\resources\\sample_forecast_response.json"),"UTF-8");

        WheaterParser.deserialize(wheatherString);




    }
}
