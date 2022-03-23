package com.microservices.ecommerce.PaymentService.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestMessage {
    PaymentMessageType messageType;
    Long cartId;
    Long orderId;
    Long paymentId;
}


