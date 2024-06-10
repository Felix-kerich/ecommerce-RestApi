package com.App.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.ecommerce.Service.AssistanceService;
import com.App.ecommerce.models.AssistanceModel;

@RestController
@RequestMapping("/assistance")
public class AssistanceController {
    public final AssistanceService assistanceService;

    public AssistanceController(AssistanceService assistanceService){
        this.assistanceService = assistanceService;
    }
    

    @PostMapping("/ask")
    public String AskForAssistance(@RequestBody AssistanceModel assistanceModel){
        assistanceService.AskForAssistance(assistanceModel);
        return "sent successfully";
    }
  
        

    @GetMapping("/")
    public List<AssistanceModel> viewAllAskedAssistance(){
        return assistanceService.viewAllAskedAssistance();
         
        
    } 
    
    @PutMapping("/update")
    public String updateAskedAssistance(@RequestBody AssistanceModel assistanceModel){
        assistanceService.updateAskedAssistance(assistanceModel);
        return "updated successfully";

    }

    @DeleteMapping("/delete")
    public String deleteAllAskedAssistance(){
        assistanceService.deleteAllAskedAssistance();
        return "deleted successfully";
    }
}
