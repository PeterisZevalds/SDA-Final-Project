package SdaFinalProject.service;

import SdaFinalProject.dto.EventDTO;
import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.dto.mapper.EventMapper;
import SdaFinalProject.dto.mapper.UserMapper;
import SdaFinalProject.entity.Event;
import SdaFinalProject.entity.User;
import SdaFinalProject.exceptions.ServiceException;
import SdaFinalProject.handler.ErrorCode;
import SdaFinalProject.repository.EventRepository;
import SdaFinalProject.repository.UserRepository;
import SdaFinalProject.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, UserValidator userValidator, EventRepository eventRepository, EventMapper eventMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }


    public UserDTO createUser(UserDTO userDto, String passHash) {
        User user = userMapper.userFromDto(userDto);
        User userCreated = userRepository.save(user);
        return userMapper.userToDto(userCreated);
    }

//    public List<UserDTO> getAllUsers() {
//        return userRepository.findAll().stream().filter(User::isActive).map(userMapper::userToDto).collect(Collectors.toList());
//    }

    public UserDTO getUserById(int id) {
        try {
            User user = userRepository.getOne((long) id);
            return userMapper.userToDto(user);
        } catch (EntityNotFoundException e) {
            throw new ServiceException(ErrorCode.ERROR_01);
        }
    }

    public List<UserDTO> usersByName(String name) {
        return userRepository.findAll().stream().filter(user -> user.getName().equals(name)).map(userMapper::userToDto).collect(Collectors.toList());
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = userMapper.userFromDto(userDTO);
        User updatedUser = userRepository.save(user);
        return userMapper.userToDto(updatedUser);
    }

//    public void deactivateUser(int id) {
//        User user = userRepository.getOne(id);
//        user.setActive(false);
//        userRepository.save(user);
//    }

    public void deleteUser(int id) {
        User user = userRepository.getOne((long) id);
        userRepository.delete(user);
    }

//    public void makeAdmin(int id) {
//        User user = userRepository.getOne(id);
//        user.setStatus(0);
//        userRepository.save(user);
//    }

    public void registerToEvent(int userId, int eventId) {
        Event newEvent = eventRepository.getOne(eventId);
        User user = userRepository.getOne((long) userId);
        List<Event> events = user.getEvents();
        events.add(newEvent);
        user.setEvents(events);
        userRepository.save(user);

    }

    public List<EventDTO> myEvents(int id) {
        return userRepository.getOne((long) id).getEvents().stream().filter(Event::isActive).map(eventMapper::eventToDTO).collect(Collectors.toList());
    }


}
