package weather;

import config.WeatherConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherRequest {

    private final static Logger logger = LogManager.getLogger(WeatherRequest.class);

    private String url;
    private String appId;
    private String units;
    private String weather;
    private String forecast;



    public WeatherRequest(WeatherConfig config) {
        this.url = config.getUrl();
        this.appId = config.getAppid();
        this.units = config.getUnits();
        this.weather = config.getWheater();
        this.forecast = config.getForecast();

    }

    public String getWeatherByCityName(String cityName) {

        String theRequest = url + weather+ cityName + "&" +units +"&"+ appId;
        logger.info("Performing request: " + theRequest);
        String theResult = "";

        try {

            URL url = new URL(theRequest);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {

                logger.error("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                theResult += output;
            }

            logger.info("Output from server: " + theResult);
            conn.disconnect();

            return theResult;

        } catch (MalformedURLException e) {
            logger.error(e.getLocalizedMessage());

        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }

        return theResult;

    }

    public String getForecastByGeoCoord(Double latitude, Double longitude){

        //https://samples.openweathermap.org/data/2.5/forecast?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22

        String theRequest = url + forecast+ "lat="+latitude + "&lon="+longitude +"&" +units +"&"+ appId;
        logger.info("Performing forecast request: " + theRequest);

        String theResult = "";

        try {

            URL url = new URL(theRequest);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {

                logger.error("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                theResult += output;
            }

            logger.info("Output from server: " + theResult);
            conn.disconnect();

            return theResult;

        } catch (MalformedURLException e) {
            logger.error(e.getLocalizedMessage());

        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }

        return theResult;

    }



}
