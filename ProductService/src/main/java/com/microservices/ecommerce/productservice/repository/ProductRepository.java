package com.microservices.ecommerce.productservice.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.microservices.ecommerce.productservice.entity.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

    @Query("{productId : ?0}")
    Optional<Product> findByProductId(Long productId);

    @Aggregation(pipeline={"{$sample:{size:?0}}"})
    AggregationResults<List<Product>> random(Long quantity);

    @Query(value = "{'category':'?0'}")
    Page<Product> findByCategory(String category, Pageable pageable);

    @Query(value = "{productId : {$in : ?0}}")
    List<Product> findProductsById(List<Long> productIds);
}
