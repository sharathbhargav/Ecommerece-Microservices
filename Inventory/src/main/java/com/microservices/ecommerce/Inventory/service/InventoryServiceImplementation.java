package com.microservices.ecommerce.Inventory.service;

import com.microservices.ecommerce.Inventory.entity.Inventory;
import com.microservices.ecommerce.Inventory.entity.InventoryRepository;
import com.microservices.ecommerce.Inventory.error.InvalidQuantityException;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryServiceImplementation implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public int getQuantity(Long productId) {
        inventoryRepository.findQuantityByProductId(productId);
        return 0;
    }

    @Override
    public Inventory updateQuantity(Long productId, int newQuantity) throws InvalidQuantityException {
        Inventory inventory = inventoryRepository.findById(productId).get();
        if(newQuantity>0){
            inventory.setQuantity(newQuantity);

        }
        else{
            throw new InvalidQuantityException("New quantity being set is " +
                    "less than zero. Invalid operation");
        }
        return inventoryRepository.save(inventory);
    }
}
