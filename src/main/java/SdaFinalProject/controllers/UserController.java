package SdaFinalProject.controllers;



import SdaFinalProject.dto.EventDTO;
import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


   @PostMapping("/createUser")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return userService.createUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

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

    @PostMapping("/user({id})/event({eventId})")
    public void registerToEvent(@PathVariable(name = "id") int userId, @PathVariable int eventId) {
        userService.registerToEvent(userId, eventId);
    }

    @GetMapping("/user({id})/events")
    public List<EventDTO> myEvents(@PathVariable int id ) {
         return userService.myEvents(id);
    }

}
