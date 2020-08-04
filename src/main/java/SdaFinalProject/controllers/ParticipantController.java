package SdaFinalProject.controllers;

import SdaFinalProject.dto.ParticipantDTO;
import SdaFinalProject.dto.request.ParticipantCreateRequestDTO;
import SdaFinalProject.service.ParticipantService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rest/Participant")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/participants")
    public List<ParticipantDTO> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    @PostMapping(value = "/participants", consumes = "application/json")
    public ParticipantDTO createParticipant(@RequestBody ParticipantCreateRequestDTO participantCreateRequestDTO) {
        System.out.println(ReflectionToStringBuilder.reflectionToString(participantCreateRequestDTO));

        return participantService.createParticipant(participantCreateRequestDTO.getParticipantDTO(),
                participantCreateRequestDTO.getPassHash());
    }
}
