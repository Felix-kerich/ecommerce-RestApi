package com.App.ecommerce.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.App.ecommerce.Repository.ProductRepo;
import com.App.ecommerce.models.Product;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public String saveProduct(Product product){
        productRepo.save(product);
        return "product saved successfully";
    }
    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }
    public Product getProductById(Long id){
        return productRepo.findById(id).get();
        
    }
    public String deleteElementById(Long id){
        productRepo.deleteById(id);
        return "product deleted successfully";
    }
    public String deleteAllProducts(){
        productRepo.deleteAll();
        return "all products deleted";
    }
   

}
