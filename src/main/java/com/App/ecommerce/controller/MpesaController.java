package com.App.ecommerce.controller;


import com.App.ecommerce.Service.MpesaService;
import com.App.ecommerce.models.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/mpesa")
public class MpesaController {

    @Autowired
    private MpesaService mpesaService;

    @PostMapping("/stkpush")
    public String initiateStkPush(@RequestBody Payment payment) {
        try {
            return mpesaService.performStkPush(payment.getPhoneNumber(), payment.getUsername(), payment.getAmount());
        } catch (IOException e) {
            e.printStackTrace();
            mpesaService.SaveMpesaDetails(payment);
            return "Error occurred: " + e.getMessage();
        }
        
    }
}
