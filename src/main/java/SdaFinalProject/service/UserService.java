package SdaFinalProject.service;

import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.dto.mapper.UserMapper;
import SdaFinalProject.entity.User;
import SdaFinalProject.exceptions.ServiceException;
import SdaFinalProject.handler.ErrorCode;
import SdaFinalProject.repository.UserRepository;
import SdaFinalProject.service.validator.UserValidator;
import SdaFinalProject.service.validator.user.UserValidationService;
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
    private UserValidationService userValidationService;


    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }

    public int createUser(User user) {
        userValidationService.validate(user);
        return userRepository.save(user).getId();
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().filter(User::getIsActive).map(userMapper::userToDto).collect(Collectors.toList());
    }

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

    public void deactivateUser(int id) {
        User user = userRepository.getOne((long) id);
        user.setIsActive(false);
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        User user = userRepository.getOne((long) id);
        userRepository.delete(user);
    }

    public void makeAdmin(int id) {
        User user = userRepository.getOne((long) id);
        user.setStatus(0);
        userRepository.save(user);
    }

}
