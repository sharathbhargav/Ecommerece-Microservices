package com.microservices.ecommerce.Inventory.service;

import com.microservices.ecommerce.Inventory.entity.Inventory;
import com.microservices.ecommerce.Inventory.error.InvalidQuantityException;

public interface InventoryService {

    public int getQuantity(Long productId);

    public Inventory updateQuantity(Long productId, int newQuantity) throws InvalidQuantityException;

}
