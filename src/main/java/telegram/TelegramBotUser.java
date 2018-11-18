package telegram;

import org.telegram.telegrambots.meta.api.objects.User;

public class TelegramBotUser {

    private long chat_id;
    private String firstName;
    private String lastName;
    private String userName;

    public TelegramBotUser() {

    }

    public TelegramBotUser(long chat_id, User user) {
        this.chat_id = chat_id;
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
    }


    public long getChat_id() {
        return chat_id;
    }

    public void setChat_id(long chat_id) {
        this.chat_id = chat_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "TelegramBotUser{" +
                "chat_id=" + chat_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }


}
