package com.App.ecommerce.User;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public UserDTO saveUser(UserDTO userDTO){
        UserModel userModel = Mapper.mapToUserModel(userDTO);
        UserModel savedUser = userRepo.save(userModel);
        return Mapper.mapToUserDTO(savedUser);
    } 

    public UserDTO getuserById(Long id){
        UserModel userModel = userRepo.findById(id)
        .orElseThrow(()-> new RuntimeException("User does not Exist"));
        return Mapper.mapToUserDTO(userModel);

    }
   public List<UserDTO> getAllUsers(){
    List<UserModel> allUsers =userRepo.findAll();
    return allUsers.stream()
            .map(Mapper::mapToUserDTO)
            .collect(Collectors.toList());
   }

   public String deleteAllUsers(){
    userRepo.deleteAll();
    return "all users deleted";
   }

   public String deleteById(Long id){
    userRepo.deleteById(id);
    return "user " +id +" "  +"deleted successfully"; 
   }

 

}
