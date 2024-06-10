package com.App.ecommerce.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.App.ecommerce.Repository.AssistanceRepo;
import com.App.ecommerce.models.AssistanceModel;

@Service
public class AssistanceService {

    public final AssistanceRepo assistanceRepo;

    public AssistanceService(AssistanceRepo assistanceRepo){
        this.assistanceRepo = assistanceRepo;

    }

    public String AskForAssistance(AssistanceModel assistanceModel){
        assistanceRepo.save(assistanceModel);
        return "Send successfully";

    }

    public List<AssistanceModel> viewAllAskedAssistance(){
       return assistanceRepo.findAll();

    }

    public String deleteAllAskedAssistance(){
        assistanceRepo.deleteAll();
        return "Deleted successfully";
    }
    public String updateAskedAssistance(AssistanceModel assistanceModel){
        assistanceRepo.save(assistanceModel);
        return "Updated successfully";
        
    }


}
