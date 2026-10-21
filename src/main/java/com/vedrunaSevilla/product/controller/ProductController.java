package com.vedrunaSevilla.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunaSevilla.product.persistance.model.Product;
import com.vedrunaSevilla.product.service.ProductService;

@RestController
@RequestMapping ("/api/v1/products")
@CrossOrigin 
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping 
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
