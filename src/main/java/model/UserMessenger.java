package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "j_user_notification")
public class UserMessenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String messenger;
    private String identify;


    public UserMessenger() {
    }

    public UserMessenger(int id, String messenger, String identify) {
        this.id = id;
        this.messenger = messenger;
        this.identify = identify;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    @Override
    public String toString() {
        return "UserMessenger{" +
                "id=" + id +
                ", messenger='" + messenger + '\'' +
                ", identify='" + identify + '\'' +
                '}';
    }
}
