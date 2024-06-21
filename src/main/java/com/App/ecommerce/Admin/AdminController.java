package com.App.ecommerce.Admin;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {
    AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/create-admin")
        public String saveEmployee(@RequestBody AdminDTO adminDTO){
            adminService.saveAdminDetails(adminDTO);
            return "Admin created";

        }
    @GetMapping("/")
    public List<AdminDTO> getAllEmployees(){
        return adminService.getAllAdmins();
    }

    
}
