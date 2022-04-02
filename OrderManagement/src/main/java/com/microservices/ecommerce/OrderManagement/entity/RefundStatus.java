package com.microservices.ecommerce.OrderManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundStatus {
    String status="NOT_STARTED";
    Long timeStamp;
}
