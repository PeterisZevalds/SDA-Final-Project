package SdaFinalProject.dto.mapper;

import SdaFinalProject.dto.ParticipantDTO;
import SdaFinalProject.entity.Participant;
import org.springframework.stereotype.Service;

@Service
public class ParticipantMapper {

    public ParticipantDTO participantToDTO (Participant participant) {
        ParticipantDTO participantDTO = new ParticipantDTO();
        participantDTO.setId(participant.getId());
        participantDTO.setName(participant.getName());
        participantDTO.setSurname(participant.getSurname());
        participantDTO.setEmail(participant.getEmail());
        return participantDTO;
    }

    public ParticipantDTO participantToDTO (Participant participant, String hash) {
        ParticipantDTO participantDTO = new ParticipantDTO();
        participantDTO.setId(participant.getId());
        participantDTO.setName(participant.getName());
        participantDTO.setSurname(participant.getSurname());
        participantDTO.setEmail(participant.getEmail());
        participantDTO.setParticipantHash(hash);
        return participantDTO;
    }

    public Participant fromDTO (ParticipantDTO participantDTO) {
        Participant participant = new Participant();
        participant.setId(participantDTO.getId());
        participant.setName(participantDTO.getName());
        participant.setSurname(participantDTO.getSurname());
        participant.setEmail(participantDTO.getEmail());
        return participant;
    }


}
