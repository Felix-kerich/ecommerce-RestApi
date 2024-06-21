package com.App.ecommerce.Assistance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AssistanceDTO {

    private Long id;
    private String username;
    private String Problem;
    private String ProblemDescription;


}