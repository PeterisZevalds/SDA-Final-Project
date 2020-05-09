package SdaFinalProject.service;

import SdaFinalProject.dto.EventDTO;
import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.dto.mapper.EventMapper;
import SdaFinalProject.dto.mapper.UserMapper;
import SdaFinalProject.entity.Event;
import SdaFinalProject.entity.User;
import SdaFinalProject.repository.EventRepository;
import SdaFinalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Autowired
    public EventService(EventRepository eventRepository, EventMapper eventMapper, UserRepository userRepository, UserMapper userMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = eventMapper.eventFromDTO(eventDTO);
        Event eventCreated = eventRepository.save(event);
        return eventMapper.eventToDTO(eventCreated);
    }

    public List<EventDTO> allEvents() {
        return eventRepository.findAll()
                .stream().filter(Event::isActive).map(eventMapper::eventToDTO)
                .collect(Collectors.toList());
    }

    public void updateEvent(int id, EventDTO eventDTO) {
        Event event = eventRepository.getOne(id);
        event = eventMapper.eventFromDTO(eventDTO);
        eventRepository.save(event);
    }

    public void deactivateEvent(int id) {
        Event event = eventRepository.getOne(id);
        event.setActive(false);
        eventRepository.save(event);
    }

    public List<UserDTO> eventUsers(int id) {
        return eventRepository.getOne(id).getUsers().stream().filter(User::isActive).map(userMapper::userToDto).collect(Collectors.toList());
    }
}
