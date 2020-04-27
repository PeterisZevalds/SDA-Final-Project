package SdaFinalProject.dto.mapper;

import SdaFinalProject.dto.EventDTO;
import SdaFinalProject.entity.Event;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    public EventDTO eventToDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getEventName());
        eventDTO.setDate(event.getEventDate());
        eventDTO.setStreet(event.getEventStreet());
        eventDTO.setCity(event.getEventCity());
        eventDTO.setPrice(event.getEventPrice());
        eventDTO.setMaxVisitors(event.getEventMaxVisitors());
        eventDTO.setDuration(event.getEventDuration());
        eventDTO.setLink(event.getEventPictureLink());
        eventDTO.setEmail(event.getEventEmail());
        eventDTO.setPhone(event.getEventPhoneNumber());
        eventDTO.setActive(true);
        return eventDTO;
    }

    public Event eventFromDTO(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setEventName(eventDTO.getName());
        event.setEventDate(eventDTO.getDate());
        event.setEventStreet(eventDTO.getStreet());
        event.setEventCity(eventDTO.getCity());
        event.setEventPrice(eventDTO.getPrice());
        event.setEventMaxVisitors(eventDTO.getMaxVisitors());
        event.setEventDuration(eventDTO.getDuration());
        event.setEventPictureLink(eventDTO.getLink());
        event.setEventEmail(eventDTO.getEmail());
        event.setEventPhoneNumber(eventDTO.getPhone());
        event.setActive(eventDTO.isActive());
        return event;
    }
}
