package SdaFinalProject.dto.request;

import SdaFinalProject.dto.ParticipantDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("")
public class ParticipantCreateRequestDTO {
    @JsonProperty("participant_dto")
    private ParticipantDTO participantDTO;
    @JsonProperty("password_hash")
    private String passHash;

    public ParticipantDTO getParticipantDTO() {
        return participantDTO;
    }

    public void setParticipantDTO(ParticipantDTO participantDTO) {
        this.participantDTO = participantDTO;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
