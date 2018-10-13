package weather;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;

import java.util.ArrayList;
import java.util.List;

public class WheaterParser {

    public static List<ForecastObject> deserialize(String wheaterString){

        List<ForecastObject> forecastObjectList = new ArrayList<>();

        Any any = JsonIterator.deserialize(wheaterString);
        Any listOfForecast = any.get("list");
        List<Any> forecastList = listOfForecast.asList();
        for(int i = 0; i< forecastList.size(); i++){

            ForecastObject tempForeastObject = new ForecastObject();

            Any current = forecastList.get(i);


            tempForeastObject.setTimestampString(current.get("dt_txt").toString());


            tempForeastObject.setCurrentDt(Long.valueOf(current.get("dt").toLong()));

            Any currentMain = current.get("main");

            tempForeastObject.setCurrentTemp(Float.valueOf(currentMain.get("temp").toFloat()));


            Any currentWeather = current.get("weather").get(0);
            tempForeastObject.setCurrentWeatherId(currentWeather.get("id").toInt());
            tempForeastObject.setCurrentWeatherMain(currentWeather.get("main").toString());
            tempForeastObject.setCurrentWeatherDescription(currentWeather.get("description").toString());
            tempForeastObject.setCurrentWeatherIcon(currentWeather.get("icon").toString());

            forecastObjectList.add(tempForeastObject);


        }

        return  forecastObjectList;

    }


}
