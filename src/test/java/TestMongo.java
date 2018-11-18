import mongo.MongoAdapter;
import org.junit.Test;
import telegram.TelegramBotUser;

public class TestMongo {

    @Test
    public void testMongoConnection(){

        MongoAdapter mongoAdapter = new MongoAdapter("mongodb://localhost:27017","weatherTelegramBot","users");

        TelegramBotUser user = new TelegramBotUser();
        user.setChat_id(123456);
        user.setFirstName("gfm1");
        user.setLastName("ml1n");
        user.setUserName("gme1loni");

        mongoAdapter.check(user);

        mongoAdapter.close();



    }




}
