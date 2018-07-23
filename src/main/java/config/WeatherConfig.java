package config;

public class WeatherConfig {

    String url;
    String appid;
    String wheater;
    String forecast;
    String units;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWheater() {
        return wheater;
    }

    public void setWheater(String wheather) {
        this.wheater = wheather;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "WeatherConfig{" +
                "url='" + url + '\'' +
                ", appid='" + appid + '\'' +
                ", wheater='" + wheater + '\'' +
                ", forecast='" + forecast + '\'' +
                ", units='" + units + '\'' +
                '}';
    }
}
