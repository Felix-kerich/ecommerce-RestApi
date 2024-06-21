package com.App.ecommerce.User;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
     private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        UserDTO savedUserDTO = userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }


    // @PostMapping("/save")
    // public String saveuser(@RequestBody UserDTO userDTO){
    //     userService.saveUser(userDTO);
    //     return "user saved successfully";
    // } 

    // @GetMapping("/{id}")
    // public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
    //     UserDTO userDTO = userService.getuserById(id);
    //     return ResponseEntity.ok(userDTO);
    // }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id){
       return userService.getuserById(id);
    }
    @GetMapping("/")
    public List<UserDTO> findAllUsers(){
        return userService.getAllUsers();
    }
    @DeleteMapping("/delete_all")
    public String deleteAllUsers(){
        userService.deleteAllUsers();
        return "All users deleted";
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return "user " +id +" " +"deleted successfully";
    }






}
