package SdaFinalProject.dto.mapper;

import SdaFinalProject.dto.ParticipantDTO;
import SdaFinalProject.entity.Participant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantMapperTest {

    private ParticipantMapper participantMapper = new ParticipantMapper();

    @Test
    void participantToDTO() {
        Participant participant = new Participant();
        participant.setId(1L);
        participant.setName("Name");
        participant.setSurname("Surname");
        participant.setEmail("Email@email.com");

        ParticipantDTO participantDTO = participantMapper.participantToDTO(participant);
        assertEquals(Long.valueOf(1), participantDTO.getId());
        assertEquals("Name", participantDTO.getName());
        assertEquals("Surname", participantDTO.getSurname());
        assertEquals("Email@email.com", participantDTO.getEmail());
    }



    @Test
    void fromDTO() {
        ParticipantDTO participantDTO = new ParticipantDTO();
        participantDTO.setId(1L);
        participantDTO.setName("Name");
        participantDTO.setSurname("Surname");
        participantDTO.setEmail("Email@email.com");

        Participant participant = participantMapper.fromDTO(participantDTO);
        assertEquals(Long.valueOf(1), participant.getId());
        assertEquals("Name", participant.getName());
        assertEquals("Surname", participant.getSurname());
        assertEquals("Email@email.com", participant.getEmail());

    }
}
