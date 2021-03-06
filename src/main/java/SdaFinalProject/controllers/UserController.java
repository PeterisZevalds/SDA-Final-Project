package SdaFinalProject.controllers;


import SdaFinalProject.dto.EventDTO;
import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.dto.request.UserCreateRequestDTO;
import SdaFinalProject.entity.User;
import SdaFinalProject.service.UserService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/User")
public class UserController {

    //Remove @Autovired
    private final UserService userService;

    //Add @Autowired
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/createUser", consumes = "application/json")
    public UserDTO createUser(@RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        System.out.println(ReflectionToStringBuilder.reflectionToString(userCreateRequestDTO));

        return userService.createUser(userCreateRequestDTO.getUserDTO(),
                userCreateRequestDTO.getPassHash());
    }

//    @GetMapping("/users")
//    public List<UserDTO> getAllUsers() {
////        return userService.getAllUsers();
//    }

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

//    @PutMapping("/user({id})")
//    public void deactivateUser(@PathVariable int id) {
//        userService.deactivateUser(id);
//    }

    @DeleteMapping("/user({id})")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

//    @PutMapping("/user/admin({id})")
//    public void makeAdmin(@PathVariable int id) {
//        userService.makeAdmin(id);
//    }

    @PostMapping("/user({id})/event({eventId})")
    public void registerToEvent(@PathVariable(name = "id") int userId, @PathVariable int eventId) {
        userService.registerToEvent(userId, eventId);
    }

    @GetMapping("/user({id})/events")
    public List<EventDTO> myEvents(@PathVariable int id) {
        return userService.myEvents(id);
    }

}
