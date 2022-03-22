package com.microservices.ecommerce.cartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CartUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long cartId;
    public long userId;
}
