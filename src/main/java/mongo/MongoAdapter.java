package mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import telegram.TelegramBotUser;

import java.util.logging.Level;

public class MongoAdapter {

    private final static Logger logger = LogManager.getLogger(MongoAdapter.class);
    private MongoClient mongoClient;
    private String userDatabase;
    private String userCollection;


    public MongoAdapter (String mongoURI, String userDatabase, String userCollection) {
         mongoClient = new MongoClient(new MongoClientURI(mongoURI));
         this.userDatabase = userDatabase;
         this.userCollection = userCollection;
    }

    public void close(){
        mongoClient.close();
    }

    public void check(TelegramBotUser botUser) {


        MongoDatabase database = mongoClient.getDatabase(getUserDatabase());
        MongoCollection<Document> collection = database.getCollection(getUserCollection());

        logger.info("check for user "+botUser);

        Document userIdDoc = getChatIdDocumentFromTelegramBotUser(botUser);

        long numDocsRetrieved = collection.countDocuments(userIdDoc);

        if(numDocsRetrieved == 0){
            logger.info("no user with chat_id \""+ botUser.getChat_id() +"\" found");
            collection.insertOne(getUserDocumentFromTelegramBotUser(botUser));
            logger.info("user  \""+ botUser.getChat_id() +"\""+" created!");
        }
        else{
            logger.info("user with chat_id \""+ botUser.getChat_id() +"\" already exists");
        }

    }

    public String getUserDatabase() {
        return userDatabase;
    }

    public String getUserCollection() {
        return userCollection;
    }

    private Document getUserDocumentFromTelegramBotUser(TelegramBotUser botUser){

        return new Document("_id", botUser.getChat_id()).append("firstName",botUser.getFirstName()).append("lastName",botUser.getLastName()).append("userName",botUser.getUserName());

    }

    private Document getChatIdDocumentFromTelegramBotUser(TelegramBotUser botUser){
        return new Document("_id",botUser.getChat_id());
    }
}
