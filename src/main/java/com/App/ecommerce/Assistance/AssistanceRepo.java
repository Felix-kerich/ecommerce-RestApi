package com.App.ecommerce.Assistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistanceRepo extends JpaRepository<AssistanceModel,Long>{

    

}
