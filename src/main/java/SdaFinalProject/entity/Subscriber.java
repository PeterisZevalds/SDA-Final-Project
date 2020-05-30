package SdaFinalProject.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "subscribers")
public class Subscriber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
//    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_SUBSCRIBER",
//                allocationSize = 100)
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "subscriber_is_active")
    private boolean isActive;

    public Subscriber() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}


