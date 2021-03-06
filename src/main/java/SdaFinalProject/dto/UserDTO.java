package SdaFinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserDTO {

    private int id;
    private String name;
    private String surname;
    private String email;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String username;
//    private String password;
    @JsonProperty("user_hash")
    private String userHash;
    private int status;
    @JsonProperty("user_is_active")
    private boolean isActive;

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
