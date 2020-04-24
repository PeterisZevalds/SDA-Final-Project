package SdaFinalProject.controllers;


import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rest/User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }

}
