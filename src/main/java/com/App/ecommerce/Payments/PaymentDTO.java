package com.App.ecommerce.Payments;

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
public class PaymentDTO {
   
    private Long id;
    private Long phoneNumber;
    private String username;
    private double amount;
    private String product;  
    private Long productId;



}
