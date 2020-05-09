package SdaFinalProject.controllers;

import SdaFinalProject.dto.EventDTO;
import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.dto.request.EventCreateRequestDTO;
import SdaFinalProject.service.EventService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/Events")
public class EventController {

    @Autowired
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(value="/createEvent", consumes = "application/json")
    public EventDTO createEvent(@RequestBody EventCreateRequestDTO eventCreateRequestDTO) {
        System.out.println(ReflectionToStringBuilder.reflectionToString(eventCreateRequestDTO));

        return eventService.createEvent(eventCreateRequestDTO.getEventDTO());
    }

    @GetMapping("/events")
    public List<EventDTO> allEvents() {
        return eventService.allEvents();
    }

    @GetMapping("event({id})/users")
    public List<UserDTO> eventUsers(@PathVariable int id) {
         return eventService.eventUsers(id);
    }

}
