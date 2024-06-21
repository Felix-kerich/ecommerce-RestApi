package com.App.ecommerce.Admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service

public class AdminService {
    public final AdminRepo adminRepo;
    
    public AdminService(AdminRepo adminRepo){
        this.adminRepo = adminRepo;
    }
    
    public AdminDTO saveAdminDetails(AdminDTO adminDTO){
        AdminModel adminModel = AdminMapper.mapToAdminMapper(adminDTO);
        AdminModel savedAdmin = adminRepo.save(adminModel);
        return AdminMapper.mapTOAdminDTO(savedAdmin);
    }
    public List<AdminDTO> getAllAdmins(){
        List<AdminModel> findAllAdmin = adminRepo.findAll();
        return findAllAdmin.stream().map(AdminMapper::mapTOAdminDTO).collect(Collectors.toList());
    }

}


