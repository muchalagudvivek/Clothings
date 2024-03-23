package com.clothing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clothing.Payload.PaymentDetails;
import com.clothing.services.PaymentService;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{amount}")
    public ResponseEntity<PaymentDetails> CreatePayment(@PathVariable Double amount){
        PaymentDetails paymentDetails = this.paymentService.CreateOrder(amount);
        return new ResponseEntity<>(paymentDetails, HttpStatusCode.valueOf(200));
    }

}
