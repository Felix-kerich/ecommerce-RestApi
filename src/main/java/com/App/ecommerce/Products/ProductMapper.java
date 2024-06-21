package com.App.ecommerce.Products;

public class ProductMapper {
   public static ProductModel mapToProductModel(ProductDTO productDTO){
    ProductModel productModel = new ProductModel(
        productDTO.getId(),
        productDTO.getProductId(),
        productDTO.getProductName(),
        productDTO.getDescription(),
        productDTO.getPrice()
        

    );
    return productModel;
   } 


   public static ProductDTO mapTOProductDTO(ProductModel productModel){
    ProductDTO productDTO = new ProductDTO(
        productModel.getId(),
        productModel.getProductId(),
        productModel.getProductName(),
        productModel.getPrice(),
        productModel.getDescription()


    );

    return productDTO;

}
}
