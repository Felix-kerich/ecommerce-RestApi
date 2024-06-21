package com.App.ecommerce.User;

public class Mapper {
    public static UserModel mapToUserModel(UserDTO userDTO){
        UserModel userModel = new UserModel(
            userDTO.getId(),
            userDTO.getFirstName(),
            userDTO.getLastName(),
            userDTO.getUserName(),
            userDTO.getEmail(), null 
            
        );
        return userModel;
    } 

    public static UserDTO mapToUserDTO(UserModel userModel){
        UserDTO userDTO = new UserDTO(
            userModel.getId(),
            userModel.getFirstName(),
            userModel.getLastName(),
            userModel.getUserName(),
            userModel.getEmail()
        );
        return userDTO;
    }

}
