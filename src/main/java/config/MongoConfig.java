package config;

public class MongoConfig {

    /*mongo:
  uri: mongodb://localhost:27017
  database: weatherTelegramBot
  userCollection: users*/

    private String uri;
    private String database;
    private String userCollection;

    public MongoConfig() {
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(String userCollection) {
        this.userCollection = userCollection;
    }


    @Override
    public String toString() {
        return "MongoConfig{" +
                "uri='" + uri + '\'' +
                ", database='" + database + '\'' +
                ", userCollection='" + userCollection + '\'' +
                '}';
    }
}
