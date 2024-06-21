package com.App.ecommerce.Assistance;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;



@Service
public class AssistanceService {

    public final AssistanceRepo assistanceRepo;

    public AssistanceService(AssistanceRepo assistanceRepo){
        this.assistanceRepo = assistanceRepo;

    }

    public AssistanceDTO AskForAssistance(AssistanceDTO assistanceDTO){
        AssistanceModel assistanceModel = AssistanceMapper.mapToAssistanceModel(assistanceDTO); 
        AssistanceModel savedAssistance = assistanceRepo.save(assistanceModel);
        return AssistanceMapper.mapToAssistanceDTO(savedAssistance);

    }

    public List<AssistanceDTO> viewAllAskedAssistance(){
        List<AssistanceModel> findAllAssistance = assistanceRepo.findAll();
        return findAllAssistance.stream()
            .map(AssistanceMapper::mapToAssistanceDTO)
            .collect(Collectors.toList());
       

    }
    

    public String deleteAllAskedAssistance(){
        assistanceRepo.deleteAll();
        return "Deleted successfully";
    }
    public AssistanceDTO updateAskedAssistance(AssistanceDTO assistanceDTO){
        AssistanceModel assistanceModel = AssistanceMapper.mapToAssistanceModel(assistanceDTO);
        AssistanceModel updatedAssistance = assistanceRepo.save(assistanceModel);
        return AssistanceMapper.mapToAssistanceDTO(updatedAssistance);
        
    }


}
