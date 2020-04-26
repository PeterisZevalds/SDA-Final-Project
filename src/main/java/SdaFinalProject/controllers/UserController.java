package SdaFinalProject.controllers;


import SdaFinalProject.dto.DtoConverter;
import SdaFinalProject.dto.UserDTO;
import SdaFinalProject.entity.User;
import SdaFinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


/*    @PostMapping("/createUser")
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
    }*/

    @GetMapping("/registration")
    public ModelAndView newUserForm(){
        ModelAndView modelAndView = new ModelAndView("userRegistrationForm");
        UserDTO userDTO = new UserDTO();
        userDTO.setName("");
        userDTO.setPassword("");
        modelAndView.addObject("userDTO", userDTO);
        return modelAndView;
    }

    /**
     * Mapping for POST method of the user registration form. This method retrieves previously created object
     * and stores it to database. After storing user is redirected to home.html
     * @param userDTO Object passed from user registration form.
     * @return ModelAndView bound to home.html
     */
    @PostMapping("/createUser")
    public ModelAndView create(UserDTO userDTO){
        ModelAndView modelAndView = new ModelAndView("redirect:/index.html");
        User user = DtoConverter.fromDto(userDTO);
        userService.createUser(user);
        return modelAndView;
    }

}
