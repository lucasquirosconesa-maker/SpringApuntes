package com.vedrunaSevilla.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunaSevilla.product.persistance.model.Product;
import com.vedrunaSevilla.product.persistance.repository.ProductRespository;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRespository productRespository;

    public ProductServiceImpl(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRespository.findAll();
    }

}
