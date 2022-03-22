package com.microservices.ecommerce.productservice.service;

import com.microservices.ecommerce.productservice.entity.Product;
import com.microservices.ecommerce.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


    public List<Product> addProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Optional<Product> findProductById(String productId) {
        return productRepository.findById(productId);
    }
}
