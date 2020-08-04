package SdaFinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationPayloadDTO {

    @JsonProperty("participant_email")
    private String participantEmail;
    private String password;

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
