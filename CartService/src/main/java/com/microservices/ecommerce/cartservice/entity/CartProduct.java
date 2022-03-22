package com.microservices.ecommerce.cartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartProduct {
    public long cartId;
    public long productId;
    public long quantity;

    @ManyToOne()
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "cartId"
    )
    private CartUser cartUser;
}
