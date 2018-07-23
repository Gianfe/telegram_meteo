package config;

import java.util.Map;

public class YamlConfig {

    String version;
    String released;
    WeatherConfig openweathermap;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public WeatherConfig getOpenweathermap() {
        return openweathermap;
    }

    public void setOpenweathermap(WeatherConfig openweathermap) {
        this.openweathermap = openweathermap;
    }

    @Override
    public String toString() {
        return "YamlConfig{" +
                "version='" + version + '\'' +
                ", released='" + released + '\'' +
                ", openweathermap=" + openweathermap +
                '}';
    }
}