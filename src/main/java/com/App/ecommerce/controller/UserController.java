package com.App.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.ecommerce.Service.UserService;
import com.App.ecommerce.models.User;

@RestController
@RequestMapping("/user")
public class UserController {
    
     private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        userService.SaveUser(user);
        return "user saved successfullly";
    }
    @GetMapping("/")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/allUsers")
    public String deleteAllUsers(){
        userService.deleteAllUsers();
        return "All user deleted successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return "user deleted successfully";

    }
@PutMapping("/{id}")
public String updateUser(@RequestBody User user, @PathVariable  Long id){
    userService.updateUser(user);
    return "user updated successfullly";
}

}
