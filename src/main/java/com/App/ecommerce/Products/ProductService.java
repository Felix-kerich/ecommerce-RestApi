package com.App.ecommerce.Products;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public ProductDTO saveProduct(ProductDTO productDTO){
        ProductModel productModel = ProductMapper.mapToProductModel(productDTO);
        ProductModel savedProduct = productRepo.save(productModel);
        return ProductMapper.mapTOProductDTO(savedProduct);
    }
    public List<ProductDTO> findAllProducts(){
        List<ProductModel> allProducts = productRepo.findAll();
        return allProducts.stream()
            .map(ProductMapper::mapTOProductDTO)
            .collect(Collectors.toList());
        
    }
    public ProductDTO getProductById(Long id){
        ProductModel productModel = productRepo.findById(id)
           .orElseThrow(() -> new RuntimeException("product does not exist"));
        return ProductMapper.mapTOProductDTO(productModel);
        
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
