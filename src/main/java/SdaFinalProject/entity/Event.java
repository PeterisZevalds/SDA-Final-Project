package SdaFinalProject.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "event_name")
    @Size(min = 1, max = 100)
    private String eventName;

    @NotBlank
    @Column(name = "event_date")
    @Size(min = 1, max = 20)
    private String eventDate;

    @NotBlank
    @Column(name = "event_street")
    @Size(min = 1, max = 100)
    private String eventStreet;

    @NotBlank
    @Column(name = "event_city")
    @Size(min = 1, max = 20)
    private String eventCity;

    @NotBlank
    @Column(name = "event_price")
    @Size(min = 1, max = 20)
    private String eventPrice;

    @NotBlank
    @Column(name = "event_max_visitors")
    @Size(min = 1, max = 10)
    private String eventMaxVisitors;

    @NotBlank
    @Column(name = "event_duration")
    @Size(min = 1, max = 20)
    private String eventDuration;

    @NotBlank
    @Column(name = "event_link")
    @Size(min = 1, max = 50)
    private String eventLink;

    @NotBlank
    @Column(name = "event_email")
    @Size(min = 1, max = 10)
    private String eventEmail;

    @NotBlank
    @Column(name = "event_phone_number")
    @Size(min = 1, max = 20)
    private String eventPhoneNumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
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
}
