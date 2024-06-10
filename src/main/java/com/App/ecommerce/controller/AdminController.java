package com.App.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.ecommerce.Service.AdminService;
import com.App.ecommerce.models.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {
    AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/create-admin")
        public String saveEmployee(@RequestBody Admin admin){
            adminService.saveAdminDetails(admin);
            return "Admin created";

        }
    @GetMapping("/")
    public List<Admin> getAllEmployees(){
        return adminService.getAllAdmins();
    }

    
}
