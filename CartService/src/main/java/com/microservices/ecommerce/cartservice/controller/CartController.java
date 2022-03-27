package com.microservices.ecommerce.cartservice.controller;

import com.microservices.ecommerce.cartservice.entity.CartProduct;
import com.microservices.ecommerce.cartservice.service.CartServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<CartProduct>> getCartItemsByUserId(@PathVariable("userid") Long userId) throws Exception {
        log.info("Inside getCartItems of CartController");
        List<CartProduct> cartProducts = cartServiceImpl.getCartItemsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(cartProducts);
    }

    @DeleteMapping("/users/{userid}")
    public ResponseEntity<Long> deleteCartItem(@PathVariable("userid") Long userId, @RequestParam(value = "product_id") Long productId){
        log.info("Inside deleteCartItem of CartController");
        long deleteCount = cartServiceImpl.deleteCartItem(userId, productId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(deleteCount);
    }

    @PutMapping("/users/{userid}")
    public ResponseEntity<CartProduct> updateCartItem(@PathVariable("userid") Long userId, @RequestParam(value="product_id") Long productId,
                                                  @RequestParam(value="quantity", required = false) Long quantity){
        log.info("Inside putCartItems of CartController");
        if (quantity == null){
            quantity = Long.valueOf(1);
        }
        CartProduct cartProduct = cartServiceImpl.updateCartItem(userId, productId, quantity);
        return ResponseEntity.status(HttpStatus.OK)
                .body(cartProduct);
    }

    @DeleteMapping("/users/{userid}")
    public ResponseEntity<String> deleteCartByUserId(@PathVariable("userid") Long userId){
        log.info("Inside deleteFullCart of CartController");
        long deleteItemCount = cartServiceImpl.deleteCartByUserId(userId);
        String response = "Number of cart Items deleted: "+deleteItemCount;
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/{cartid}")
    public ResponseEntity<List<CartProduct>> getCartItemsByCartId(@PathVariable("cartid") Long cartId) throws Exception {
        log.info("Inside getCartItemsByCartId of CartController");
        List<CartProduct> cartItems = cartServiceImpl.getCartItemsByCartId(cartId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(cartItems);
    }

    @DeleteMapping("/{cartid}")
    public ResponseEntity<String> deleteCartByCartId(@PathVariable("cartid") Long cartId){
        log.info("Inside deleteCartByCartId of CartController");
        long deleteCount = cartServiceImpl.deleteCartByCartId(cartId);
        String response = "Number of cart Items deleted: "+deleteCount;
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


}
