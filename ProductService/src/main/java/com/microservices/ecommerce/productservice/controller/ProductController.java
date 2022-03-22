package com.microservices.ecommerce.productservice.controller;

import com.microservices.ecommerce.productservice.entity.Product;
import com.microservices.ecommerce.productservice.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        ResponseEntity<Product> response = null;
        Product savedProduct = productService.addProduct(product);
        response.status(HttpStatus.OK)
                .body(savedProduct);
        return response;
    }

    @PostMapping("/addproducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
        ResponseEntity<List<Product>> response = null;
        List<Product> savedProducts = productService.addProducts(products);
        response.status(HttpStatus.OK)
                .body(savedProducts);
        return response;
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Product> findProductById(@PathVariable("product_id") String productId){
        ResponseEntity<Product> response = null;
        Optional<Product> product = productService.findProductById(productId);
        response.status(HttpStatus.OK)
                .body(product);
        return response;
    }


}









