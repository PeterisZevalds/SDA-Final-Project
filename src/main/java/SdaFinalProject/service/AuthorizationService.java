package SdaFinalProject.service;

import SdaFinalProject.entity.Lecturer;
import SdaFinalProject.entity.Participant;
import SdaFinalProject.exceptions.ServiceException;
import SdaFinalProject.handler.ErrorCode;
import SdaFinalProject.repository.ParticipantRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final ParticipantRepository participantRepository;

    @Autowired
    public AuthorizationService (ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public String getParticipantPassword(String email) {
        Participant participant = participantRepository.findByEmail(email);
        if (participant == null) {
            throw new ServiceException(ErrorCode.ERROR_01);
        }

        return participant.getPassword();
    }

}
