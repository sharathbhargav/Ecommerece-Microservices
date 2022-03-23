package com.microservices.ecommerce.productservice.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.microservices.ecommerce.productservice.entity.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

    @Query()
    Product findByProductId(String productId);
}
