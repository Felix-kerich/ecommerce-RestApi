package com.App.ecommerce.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.App.ecommerce.Repository.AdminRepo;
import com.App.ecommerce.models.Admin;

@Service

public class AdminService {
    public final AdminRepo employeeRepo;
    
    public AdminService(AdminRepo adminRepo){
        this.employeeRepo = adminRepo;
    }
    
    public String saveAdminDetails(Admin admin){
        employeeRepo.save(admin);
        return "Admin Saved Successfully";
    }
    public List<Admin> getAllAdmins(){
        return employeeRepo.findAll();
    }

}


