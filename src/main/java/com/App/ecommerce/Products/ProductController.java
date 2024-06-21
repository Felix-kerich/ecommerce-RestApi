package com.App.ecommerce.Products;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    public final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/save")
    public String saveProduct(@RequestBody ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return "saved successdully";
    }
    @GetMapping("/")
    public List<ProductDTO> getAllProducts(){
        return productService.findAllProducts();
    }
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAllProducts(){
        productService.deleteAllProducts();
        return "All products deleted";
    }
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deleteElementById(id);
        return "product deleted successfully";
    } 

}
