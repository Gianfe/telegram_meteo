package weather;

public class WeatherObject {

    private Float latitude;
    private Float longitude;
    private int id;
    private String weatherMain;
    private String  weatherDescription;
    private String weatherIcon;
    private Float temperature;
    private Float windSpeed;
    private long currentDt;

    public WeatherObject() {

    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public long getCurrentDt() {
        return currentDt;
    }

    public void setCurrentDt(long currentDt) {
        this.currentDt = currentDt;
    }

    @Override
    public String toString() {
        return "WeatherObject{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", id=" + id +
                ", weatherMain='" + weatherMain + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", weatherIcon='" + weatherIcon + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", currentDt=" + currentDt +
                '}';
    }
}
