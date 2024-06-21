package com.App.ecommerce.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface AdminRepo extends JpaRepository<AdminModel,Long>{

    

}
