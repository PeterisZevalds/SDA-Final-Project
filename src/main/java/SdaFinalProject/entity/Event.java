package SdaFinalProject.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_date")
    private String eventDate;
    @Column(name = "event_street")
    private String eventStreet;
    @Column(name = "event_city")
    private String eventCity;
    @Column(name = "event_price")
    private String eventPrice;
    @Column(name = "event_max_visitors")
    private String eventMaxVisitors;
    @Column(name = "event_duration")
    private String eventDuration;
    @Column(name = "event_link")
    private String eventPictureLink;
    @Column(name = "event_email")
    private String eventEmail;
    @Column(name = "event_phone_number")
    private String eventPhoneNumber;
    @Column(name = "event_is_active")
    private boolean isActive;
    @ManyToMany(mappedBy = "events")
    private List<User> users;

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventStreet() {
        return eventStreet;
    }

    public void setEventStreet(String eventStreet) {
        this.eventStreet = eventStreet;
    }

    public String getEventCity() {
        return eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    public String getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(String eventPrice) {
        this.eventPrice = eventPrice;
    }

    public String getEventMaxVisitors() {
        return eventMaxVisitors;
    }

    public void setEventMaxVisitors(String eventMaxVisitors) {
        this.eventMaxVisitors = eventMaxVisitors;
    }

    public String getEventDuration() {
        return eventDuration;
    }

    public void setEventDuration(String eventDuration) {
        this.eventDuration = eventDuration;
    }

    public String getEventPictureLink() {
        return eventPictureLink;
    }

    public void setEventPictureLink(String eventLink) {
        this.eventPictureLink = eventLink;
    }

    public String getEventEmail() {
        return eventEmail;
    }

    public void setEventEmail(String eventEmail) {
        this.eventEmail = eventEmail;
    }

    public String getEventPhoneNumber() {
        return eventPhoneNumber;
    }

    public void setEventPhoneNumber(String eventPhoneNumber) {
        this.eventPhoneNumber = eventPhoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
