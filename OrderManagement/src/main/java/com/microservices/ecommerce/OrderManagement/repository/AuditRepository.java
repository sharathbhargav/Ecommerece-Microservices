package com.microservices.ecommerce.OrderManagement.repository;

import com.microservices.ecommerce.OrderManagement.entity.Audit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuditRepository extends MongoRepository<Audit, String> {

    // in service class -> find audit record and update the payment status, refund status, etc and use AuditRepository.save() method to update it.
    // see productService repository class and Service class for more usage information.
    @Query("{orderId : ?0}")
    Optional<Audit> findByOrderId(String orderId);




}
