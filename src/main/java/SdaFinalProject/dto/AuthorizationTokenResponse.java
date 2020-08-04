package SdaFinalProject.dto;

public class AuthorizationTokenResponse extends  AbstractResponseDTO {

    private String participantName;
    private String token;

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
