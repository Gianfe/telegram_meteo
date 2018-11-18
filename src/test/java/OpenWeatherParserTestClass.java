import org.apache.commons.io.FileUtils;
import org.junit.Test;
import weather.ForecastObject;
import weather.OpenWeatherParser;
import weather.WeatherObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OpenWeatherParserTestClass {

    @Test
    public void testForecastParser() throws IOException {

        String wheatherString = FileUtils.readFileToString(new File("/home/gianfe/Documenti/java_workspace/meteo/src/main/resources/sample_forecast_response.json"),"UTF-8");

        List<ForecastObject> deserializedForecastObject = OpenWeatherParser.deserializeForecast(wheatherString);

        System.out.println(deserializedForecastObject);
        System.out.println("size: "+deserializedForecastObject.size());


    }

    @Test
    public void testWeatherParser() throws IOException {

        String wheatherString = FileUtils.readFileToString(new File("/home/gianfe/Documenti/java_workspace/meteo/src/main/resources/sample_weather_response.json"),"UTF-8");

        WeatherObject deserializedWeatherObject =  OpenWeatherParser.deserializeWeather(wheatherString);

        System.out.println(deserializedWeatherObject);


    }
}
