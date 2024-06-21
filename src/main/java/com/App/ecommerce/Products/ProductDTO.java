package com.App.ecommerce.Products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
 
    private Long id;
    private Long productId;
    private String productName;
    private String price;
    private String description;

  

}
