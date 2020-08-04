package SdaFinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParticipantDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    @JsonProperty("participant_hash")
    private String participantHash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getParticipantHash() {
        return participantHash;
    }

    public void setParticipantHash(String participantHash) {
        this.participantHash = participantHash;
    }
}
