package com.App.ecommerce.Admin;

public class AdminMapper {

    public static AdminModel mapToAdminMapper(AdminDTO adminDTO){
        AdminModel adminModel = new AdminModel(
            adminDTO.getId(),
            adminDTO.getName(),
            adminDTO.getEmail(),
            adminDTO.getPassword()
        );
        return adminModel;

        
       }
    public static AdminDTO mapTOAdminDTO(AdminModel adminModel){
        AdminDTO adminDTO = new AdminDTO(
            adminModel.getId(),
            adminModel.getName(),
            adminModel.getEmail(),
            adminModel.getPassword()
            
            

        );
        return adminDTO;
    }
}
