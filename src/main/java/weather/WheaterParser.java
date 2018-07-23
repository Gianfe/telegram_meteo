package weather;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;

import java.util.List;

public class WheaterParser {

    public static void deserialize(String wheaterString){

        Any any = JsonIterator.deserialize(wheaterString);
        Any listOfForecast = any.get("list");
        List<Any> forecastList = listOfForecast.asList();
        for(int i = 0; i< forecastList.size(); i++){
            Any current = forecastList.get(i);
            String timeOfForecast = current.get("dt_txt").toString();
            System.out.println("current forecast: "+timeOfForecast);

        }

    }


}
