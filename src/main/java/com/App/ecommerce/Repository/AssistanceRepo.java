package com.App.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.ecommerce.models.AssistanceModel;

@Repository
public interface AssistanceRepo extends JpaRepository<AssistanceModel,Long>{

    

}
