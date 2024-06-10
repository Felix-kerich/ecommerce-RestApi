package com.App.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Assistance")
public class AssistanceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String Problem;
    private String ProblemDescription;


    public AssistanceModel() {
    }


    public AssistanceModel(Long id, String username, String Problem, String ProblemDescription) {
        this.id = id;
        this.username = username;
        this.Problem = Problem;
        this.ProblemDescription = ProblemDescription;
    }




    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProblem() {
        return this.Problem;
    }

    public void setProblem(String Problem) {
        this.Problem = Problem;
    }

    public String getProblemDescription() {
        return this.ProblemDescription;
    }

    public void setProblemDescription(String ProblemDescription) {
        this.ProblemDescription = ProblemDescription;
    }

}
