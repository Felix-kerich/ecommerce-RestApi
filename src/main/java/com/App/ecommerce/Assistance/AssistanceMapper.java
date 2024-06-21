package com.App.ecommerce.Assistance;

public class AssistanceMapper {
    public static AssistanceModel mapToAssistanceModel(AssistanceDTO assistanceDTO){
        AssistanceModel assistanceModel = new AssistanceModel(
            assistanceDTO.getId(),
            assistanceDTO.getUsername(),
            assistanceDTO.getProblem(),
            assistanceDTO.getProblemDescription()
        );
        return assistanceModel;
    }
    public static AssistanceDTO mapToAssistanceDTO(AssistanceModel assistanceModel){
        AssistanceDTO assistanceDTO = new AssistanceDTO(
            assistanceModel.getId(),
            assistanceModel.getUsername(),
            assistanceModel.getProblem(),
            assistanceModel.getProblemDescription()
        );
        return assistanceDTO;
    }

}
