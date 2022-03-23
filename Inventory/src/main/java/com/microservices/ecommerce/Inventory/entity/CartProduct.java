package com.microservices.ecommerce.Inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProduct {
    public long cartId;
    public long productId;
    public long quantity;
}
