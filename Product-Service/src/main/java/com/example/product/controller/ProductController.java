package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.entity.UserRequest;
import com.example.product.entity.UserResponse;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/testProduct")
    public String productTestPage()
    {
        String msg="<h2 style='color:green'>Product Service Is Working!</h2>";
        return msg;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserResponse> saveProduct(@RequestBody UserRequest userRequest)
    {
      Product product= userRequest.getProduct();
      UserResponse userResponse=productService.saveProduct(userRequest);
      return  new ResponseEntity<>( userResponse,HttpStatus.CREATED);
    }
}
