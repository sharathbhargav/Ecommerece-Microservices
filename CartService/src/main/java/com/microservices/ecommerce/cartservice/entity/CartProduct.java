package com.microservices.ecommerce.cartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@IdClass(CartProductId.class)
@Table(name="cart_product")
public class CartProduct {
//    @Id
//    public long cartId;
//    @Id
//    public long productId;
    @EmbeddedId
    private CartProductId cartProductId;
    private long quantity;

    @ManyToOne()
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "cartId"
    )
    private CartUser cartUser;

//    public CartProduct(Long cartId, Long productId, Long quantity, CartUser cartUser) {
//    }
}
