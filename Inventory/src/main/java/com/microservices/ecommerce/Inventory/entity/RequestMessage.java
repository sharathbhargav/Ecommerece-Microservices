package com.microservices.ecommerce.Inventory.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestMessage {
    OrderMessageType messageType;
    int cartId;
    int orderId;
}


