package com.example.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {


    private Integer paymentId;
    private String paymentStatus;
    private String transactionId;
    private Double amount;
    private Integer pid;
}
