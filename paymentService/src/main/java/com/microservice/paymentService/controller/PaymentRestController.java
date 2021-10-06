package com.microservice.paymentService.controller;

import com.microservice.paymentService.service.CartRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

    @Autowired
    private CartRestConsumer cartRestConsumer;

    @GetMapping("/data")
    public String getPaymentData() {
        return "FROM PAYMENT-SERVICE : " + cartRestConsumer.getCartInfo();
    }
}
