package com.App.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.ecommerce.models.Admin;

@Repository

public interface AdminRepo extends JpaRepository<Admin,Long>{

    

}
