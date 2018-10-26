package config;

import java.util.Map;

public class YamlConfig {

    private String version;
    private String released;
    private WeatherConfig openweathermap;
    private TelegramConfig telegram;

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

    public TelegramConfig getTelegram() {
        return telegram;
    }

    public void setTelegram(TelegramConfig telegram) {
        this.telegram = telegram;
    }

    @Override
    public String toString() {
        return "YamlConfig{" +
                "version='" + version + '\'' +
                ", released='" + released + '\'' +
                ", openweathermap=" + openweathermap +
                ", telegram=" + telegram +
                '}';
    }
}