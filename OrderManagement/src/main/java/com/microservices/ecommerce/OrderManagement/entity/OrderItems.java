package com.microservices.ecommerce.OrderManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    Long productId;
    Long quantity;
    Double price;
}
