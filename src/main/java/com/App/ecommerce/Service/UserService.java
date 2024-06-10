package com.App.ecommerce.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.App.ecommerce.Repository.UserRepo;
import com.App.ecommerce.models.User;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public String SaveUser(User user){
        userRepo.save(user);
        return "user saved successfully";
    }
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }
    public User getUserById(Long id){
        return userRepo.findById(id).get();

    }
    public String deleteAllUsers(){
        userRepo.deleteAll();
        return "All users deleted successfully ";

    }
    public String deleteUserById(Long id){
        userRepo.deleteById(id);
        return "user deleted succussfully";

    }
    public String updateUser(User user){
        userRepo.save(user);
        return "user Updated successfully";
    }

}
