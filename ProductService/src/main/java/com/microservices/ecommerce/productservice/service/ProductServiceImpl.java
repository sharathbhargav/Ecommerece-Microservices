package com.microservices.ecommerce.productservice.service;

import com.microservices.ecommerce.productservice.entity.Product;
import com.microservices.ecommerce.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    public Product addProduct(Product product) {
        product.setProductId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
        return productRepository.save(product);
    }


    public List<Product> addProducts(List<Product> products) {
        for (Product product : products){
            product.setProductId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
        }
        return productRepository.saveAll(products);
    }

    public Product findProductById(Long productId) throws Exception {
//        return productRepository.findByProductId(productId).orElseThrow(()
//                -> new Exception("Product Not found: " + productId));
        Optional<Product> dbResponse = productRepository.findByProductId(productId);
        if (dbResponse.isPresent()){
            return dbResponse.get();
        }
        else{
            throw new Exception("Product not found: "+productId);
        }
    }


    public List<List<Product>> getRecommendations(Long quantity) throws Exception {
        List<List<Product>> result = productRepository.random(quantity).getMappedResults();
        if (! result.isEmpty()){
            return result;
        }
        else{
            throw new Exception("Not enough products in database: "+quantity);
        }
    }

    public List<Product> findByCategory(String category, Long quantity) {
        Pageable pageable = PageRequest.of(0, Math.toIntExact(quantity));
        Page<Product> responsePage = productRepository.findByCategory(category, pageable);
        return responsePage.stream().collect(Collectors.toList());
    }

    public List<Product> findProductsById(List<Long> productIds) {
        return productRepository.findProductsById(productIds);
    }
}








