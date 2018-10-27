package weather;

public class WeatherObject {

    private String timestampString;
    private long currentDt;
    private float currentTemp ;
    private int currentWeatherId;
    private String currentWeatherMain;
    private String currentWeatherDescription ;
    private String currentWeatherIcon ;

    public WeatherObject() {
    }


    public String getTimestampString() {
        return timestampString;
    }

    public void setTimestampString(String timestampString) {
        this.timestampString = timestampString;
    }

    public long getCurrentDt() {
        return currentDt;
    }

    public void setCurrentDt(long currentDt) {
        this.currentDt = currentDt;
    }

    public float getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(float currentTemp) {
        this.currentTemp = currentTemp;
    }

    public int getCurrentWeatherId() {
        return currentWeatherId;
    }

    public void setCurrentWeatherId(int currentWeatherId) {
        this.currentWeatherId = currentWeatherId;
    }

    public String getCurrentWeatherMain() {
        return currentWeatherMain;
    }

    public void setCurrentWeatherMain(String currentWeatherMain) {
        this.currentWeatherMain = currentWeatherMain;
    }

    public String getCurrentWeatherDescription() {
        return currentWeatherDescription;
    }

    public void setCurrentWeatherDescription(String currentWeatherDescription) {
        this.currentWeatherDescription = currentWeatherDescription;
    }

    public String getCurrentWeatherIcon() {
        return currentWeatherIcon;
    }

    public void setCurrentWeatherIcon(String currentWeatherIcon) {
        this.currentWeatherIcon = currentWeatherIcon;
    }

    @Override
    public String toString() {
        return "ForecastObject{" +
                "timestampString='" + timestampString + '\'' +
                ", currentDt=" + currentDt +
                ", currentTemp=" + currentTemp +
                ", currentWeatherId=" + currentWeatherId +
                ", currentWeatherMain='" + currentWeatherMain + '\'' +
                ", currentWeatherDescription='" + currentWeatherDescription + '\'' +
                ", currentWeatherIcon='" + currentWeatherIcon + '\'' +
                '}';
    }
}
