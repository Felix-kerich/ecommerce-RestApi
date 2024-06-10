package com.App.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.ecommerce.models.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
