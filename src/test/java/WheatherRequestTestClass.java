import config.WeatherConfig;
import org.junit.Test;
import weather.WeatherRequest;

public class WheatherRequestTestClass {

    @Test
    public void testGetWeatherByCityName() {

        WeatherConfig config = new WeatherConfig();
        config.setAppid("appid=96508ef365164a7643f9a49fb8c5b0bd");
        config.setUrl("http://api.openweathermap.org/data/2.5/");
        config.setUnits("units=metric");
        config.setWheater("weather?q=");
        WeatherRequest request = new WeatherRequest(config);
        request.getWeatherByCityName("Rome,Italy");


    }

    @Test
    public void testGetForecastByCityName(){

        //41.8912288,12.5744462 traffic live club lat long

        WeatherConfig config = new WeatherConfig();
        config.setAppid("appid=96508ef365164a7643f9a49fb8c5b0bd");
        config.setUrl("http://api.openweathermap.org/data/2.5/");
        config.setUnits("units=metric");
        config.setForecast("forecast?");
        WeatherRequest request = new WeatherRequest(config);
        request.getForecastByGeoCoord(41.8912288, 12.5744462);




    }
}
