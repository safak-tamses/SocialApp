package com.example.webapp.Controller;
import com.example.webapp.Entities.User;
import com.example.webapp.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @PostMapping()
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
    @PutMapping("/{userId}")
    public void updateUser(@PathVariable Long userId,@RequestBody User user) throws Exception {
        userService.updateUserById(userId,user);
    }
    @DeleteMapping("/userId")
    public void deleteUser(@PathVariable Long userId) throws Exception {
        userService.deleteUserById(userId);
    }

}
