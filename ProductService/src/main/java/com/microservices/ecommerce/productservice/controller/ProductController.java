package com.microservices.ecommerce.productservice.controller;

import com.microservices.ecommerce.productservice.entity.Product;
import com.microservices.ecommerce.productservice.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedProduct);
    }

    @PostMapping("/addproducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
        List<Product> savedProducts = productService.addProducts(products);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedProducts);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Product> findProductById(@PathVariable("product-id") Long productId) throws Exception {
        Product product = productService.findProductById(productId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(product);
    }

    @GetMapping("by-id")
    public ResponseEntity<List<Product>> findProductsById(@RequestParam (value="product-ids") List<Long> productIds) throws Exception {
        List<Product> products = productService.findProductsById(productIds);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(products);
    }

    // This is not working.
//    @GetMapping("/recommendations")
//    public ResponseEntity<List<List<Product>>> getRecommendations(@RequestParam (value="quantity") Long quantity) throws Exception {
//        List<List<Product>> recommendations = productService.getRecommendations(quantity);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(recommendations);
//    }

    @GetMapping()
    public ResponseEntity<List<Product>> getCategoryProducts(@RequestParam (value="category") String category, @RequestParam (value="quantity") Long quantity){
        List<Product> savedProducts = productService.findByCategory(category, quantity);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedProducts);
    }




}









