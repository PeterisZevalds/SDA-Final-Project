package SdaFinalProject.dto.mapper;

import SdaFinalProject.dto.EventDTO;
import SdaFinalProject.entity.Event;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    public EventDTO eventDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getEventName());
        eventDTO.setDate(event.getEventDate());
        eventDTO.setStreet(event.getEventStreet());
        eventDTO.setCity(event.getEventCity());

        return eventDTO;
    }
}
