package com.example.product.service;

import com.example.product.controller.PaymentServiceClient;
import com.example.product.entity.Payment;
import com.example.product.entity.Product;
import com.example.product.entity.UserRequest;
import com.example.product.entity.UserResponse;
import com.example.product.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    private static final String url="http://PAYMENT-SERVICE/payment/makePayment";

    @Autowired
    private ProductRepository productRepository;

    @Override
    public UserResponse saveProduct(UserRequest userRequest) {
        Double price=9000.3;
        Product product=userRequest.getProduct();
        Double finalPrice=userRequest.getProduct().getQuantity()*price;
        product.setPrice(finalPrice);
        Product savedProduct=productRepository.save(product);
        Payment payment=new Payment();
        payment.setPid(savedProduct.getPid());
        payment.setAmount(finalPrice);
        Payment savedPayment=paymentServiceClient.makePayment(payment);
        return new UserResponse(savedProduct,savedPayment);
    }
}
