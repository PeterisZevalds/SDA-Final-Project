package SdaFinalProject.service;

import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.dto.mapper.UserMapper;
import SdaFinalProject.entity.User;
import SdaFinalProject.repository.UserRepository;
import SdaFinalProject.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }

    public void createUser(UserDTO userDto) {
        User user = userMapper.userFromDto(userDto);
        userRepository.save(user);
    }
}
