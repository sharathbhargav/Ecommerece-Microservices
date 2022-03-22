package com.microservices.ecommerce.productservice.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.microservices.ecommerce.productservice.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
