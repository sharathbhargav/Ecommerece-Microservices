package com.microservices.ecommerce.productservice.service;

import com.microservices.ecommerce.productservice.entity.Product;
import com.microservices.ecommerce.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Product findProductById(String productId) throws Exception {
//        return productRepository.findByProductId(productId).orElseThrow(()
//                -> new Exception("Product Not found: " + productId));
        return productRepository.findByProductId(productId);
    }


}
