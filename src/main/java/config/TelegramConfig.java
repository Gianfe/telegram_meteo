package config;

public class TelegramConfig {

    private String name;
    private String api;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "TelegramConfig{" +
                "name='" + name + '\'' +
                ", api='" + api + '\'' +
                '}';
    }
}
