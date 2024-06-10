package com.App.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.ecommerce.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {



}
