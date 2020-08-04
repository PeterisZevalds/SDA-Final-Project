package SdaFinalProject.service;

import SdaFinalProject.database.NoSQLDatabaseService;
import SdaFinalProject.dto.ParticipantDTO;
import SdaFinalProject.dto.mapper.ParticipantMapper;
import SdaFinalProject.entity.Participant;
import SdaFinalProject.repository.ParticipantRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantServiceTest {

    private ParticipantRepository participantRepository = mock(ParticipantRepository.class);
    private NoSQLDatabaseService noSQLDatabaseService = mock(NoSQLDatabaseService.class);
    ParticipantService participantService = new ParticipantService(noSQLDatabaseService, participantRepository, new ParticipantMapper());

    @Test
    void createParticipant() {
    }

    @Test
    void getAllParticipants() {
        List<ParticipantDTO> participantsBeforeAdd = participantService.getAllParticipants();

        Participant participant = new Participant();
        participant.setId(1L);

        when(participantRepository.findAll()).thenReturn(Collections.singletonList(participant));
        List<ParticipantDTO> participantAfterAdd = participantService.getAllParticipants();

        assertEquals(participantAfterAdd.size(), participantsBeforeAdd.size()+1);
    }
}
