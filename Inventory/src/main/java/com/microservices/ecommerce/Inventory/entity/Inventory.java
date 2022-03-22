package com.microservices.ecommerce.Inventory.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
    @Id
    @SequenceGenerator(name = "inventory_sequence", sequenceName =
            "inventory_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "inventory_sequence")
    Long inventoryId;

    Long productId;

    @Min(value=0, message = "Quantity cannot be less than zero")
    int quantity;

}
