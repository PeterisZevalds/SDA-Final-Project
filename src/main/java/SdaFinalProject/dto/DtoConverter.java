package SdaFinalProject.dto;

import SdaFinalProject.entity.*;

/**
 * Class for converting Objects to and from DTO objects.
 * DTO objects are used for data passing to html documents, therefore
 * better encapsulation is achieved compared to passing entity Objects.
 */
public class DtoConverter {

    /**
     * Converts User object to DTO user object.
     *
     * @param user User object to be converted
     * @return
     */
    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUsername(user.getUsername());
//        userDTO.setPassword(user.getPassword());
        userDTO.setStatus(user.getStatus());
//        userDTO.setActive(user.getIsActive());
        return userDTO;
    }

    /**
     * Converts DtoUser object back to User object.
     *
     * @param userDTO DtoUser object to be converted.
     * @return
     */
    public static User fromDto(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUsername(userDTO.getUsername());
//        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.getStatus());
//        user.setIsActive(userDTO.getIsActive());
        return user;
    }
}
