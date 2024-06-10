package com.App.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.ecommerce.models.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long>{


}
