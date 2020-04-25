package SdaFinalProject.controllers;


import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {return userService.getAllUsers();}

    @GetMapping("/user({id})")
    public UserDTO getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users({name})")
    public List<UserDTO> userByName(@PathVariable String name) {
        return userService.usersByName(name);
    }

    @PutMapping("/user/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @PutMapping("/user({id})")
    public void deactivateUser(@PathVariable int id) {
        userService.deactivateUser(id);
    }

    @DeleteMapping("/user({id})")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PutMapping("/user/admin({id})")
    public void makeAdmin(@PathVariable int id) {
        userService.makeAdmin(id);
    }

}
