package SdaFinalProject.dto.mapper;

import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO userToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setStatus(user.getStatus());
        userDTO.setActive(user.isActive());
        return userDTO;
    }

    public User userFromDto(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setActive(true);
        user.setStatus(1);
        return user;
    }
}
