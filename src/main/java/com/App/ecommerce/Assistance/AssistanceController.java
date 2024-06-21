package com.App.ecommerce.Assistance;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assistance")
public class AssistanceController {
    public final AssistanceService assistanceService;

    public AssistanceController(AssistanceService assistanceService){
        this.assistanceService = assistanceService;
    }
    

    @PostMapping("/ask")
    public String AskForAssistance(@RequestBody AssistanceDTO assistanceDTO){
        assistanceService.AskForAssistance(assistanceDTO);
        return "sent successfully";
    }
  
        

    @GetMapping("/")
    public List<AssistanceDTO> viewAllAskedAssistance(){
        return assistanceService.viewAllAskedAssistance();
         
        
    } 
    
    @PutMapping("/update")
    public String updateAskedAssistance(@RequestBody AssistanceDTO assistanceDTO){
        assistanceService.updateAskedAssistance(assistanceDTO);
        return "updated successfully";

    }

    @DeleteMapping("/delete")
    public String deleteAllAskedAssistance(){
        assistanceService.deleteAllAskedAssistance();
        return "deleted successfully";
    }
}
