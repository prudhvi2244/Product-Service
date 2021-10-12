package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.entity.UserRequest;
import com.example.product.entity.UserResponse;

public interface IProductService {
    public UserResponse saveProduct(UserRequest userRequest);
}
