package com.microservices.ecommerce.cartservice.controller;

import com.microservices.ecommerce.cartservice.entity.CartProduct;
import com.microservices.ecommerce.cartservice.service.CartServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@Slf4j
public class CartController {
    @Autowired
    public CartServiceImpl cartServiceImpl;

    @GetMapping("/users/{userid}")
    public List<CartProduct> getCartItemsByUserId(@PathVariable("userid") Long userId){
        log.info("Inside getCartItems of CartController");
        return cartServiceImpl.getCartItemsByUserId(userId);
    }

    @DeleteMapping("/users/{userid}")
    public ResponseEntity<Boolean> deleteCartItem(@PathVariable("userid") Long userId, @RequestParam(value = "product_id") Long productId){
        ResponseEntity<Boolean> response = null;
        log.info("Inside deleteCartItem of CartController");
        int deleteCount = cartServiceImpl.deleteCartItem(userId, productId);
        // TODO: create a response body
        return response;
    }

    @PutMapping("/users/{userid}")
    public ResponseEntity<Boolean> updateCartItem(@PathVariable("userid") Long userId, @RequestParam(value="product_id") Long productId,
                                                  @RequestParam(value="quantity", required = false) Long quantity){
        ResponseEntity<Boolean> response = null;
        log.info("Inside putCartItems of CartController");
        // TODO: create a response body
        int updateCount = cartServiceImpl.updateCartItem(userId, productId, quantity);
        return response;
    }

    @DeleteMapping("/users/{userid}")
    public ResponseEntity<Boolean> deleteCartByUserId(@PathVariable("userid") Long userId){
        ResponseEntity<Boolean> response = null;
        log.info("Inside deleteFullCart of CartController");
        Boolean deleteSuccess = cartServiceImpl.deleteCartByUserId(userId);
        // TODO: create a response body
        return response;
    }

    @GetMapping("/{cartid}")
    public ResponseEntity<CartProduct> getCartItemsByCartId(@PathVariable("cartid") Long cartId){
        log.info("Inside getCartItemsByCartId of CartController");
        List<CartProduct> cartItems = cartServiceImpl.getCartItemsByCartId(cartId);
        ResponseEntity<CartProduct> response = null;
        // TODO: create a response body
        return response;
    }

    @DeleteMapping("/{cartid}")
    public ResponseEntity<Boolean> deleteCartByCartId(@PathVariable("cartid") Long cartId){
        ResponseEntity<Boolean> response = null;
        log.info("Inside deleteCartByCartId of CartController");
        Boolean deleteSuccess = cartServiceImpl.deleteCartByCartId(cartId);
        // TODO: create a response body
        return response;
    }


}
