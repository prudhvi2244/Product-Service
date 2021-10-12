package com.example.product.controller;

import com.example.product.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentServiceClient {

    @PostMapping(value = "/payment/makePayment")
    public Payment makePayment(Payment payment);
}

