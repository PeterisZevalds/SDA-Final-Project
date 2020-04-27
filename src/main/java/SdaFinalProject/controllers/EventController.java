package SdaFinalProject.controllers;

import SdaFinalProject.dto.EventDTO;
import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/createEvent")
    public void createEvent(@RequestBody EventDTO eventDTO) {
        eventService.createEvent(eventDTO);
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
