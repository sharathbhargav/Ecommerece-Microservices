package com.microservices.ecommerce.cartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart_user")
public class CartUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long cartId;
    public long userId;

//    public CartUser(Long userId) {
//    }
}
