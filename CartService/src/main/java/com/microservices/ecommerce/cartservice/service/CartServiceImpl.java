package com.microservices.ecommerce.cartservice.service;

import com.microservices.ecommerce.cartservice.entity.CartProduct;
import com.microservices.ecommerce.cartservice.entity.CartUser;
import com.microservices.ecommerce.cartservice.repository.CartProductRepository;
import com.microservices.ecommerce.cartservice.repository.CartUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartUserRepository cartUserRepository;
    @Autowired
    private CartProductRepository cartProdRepo;

    public List<CartProduct> getCartItemsByUserId(Long userId) {
        CartUser cartUser = cartUserRepository.findCartByUserId(userId);
        List<CartProduct> cartItems = null;
        if (cartUser != null){
            cartItems = cartProdRepo.findByCartId(cartUser.getCartId());
        }
        return cartItems;
    }

    public int deleteCartItem(Long userId, Long productId) {
        CartUser cartUser = cartUserRepository.findCartByUserId(userId);
        int deleteSuccess = 0;
        if (cartUser != null){
            deleteSuccess = cartProdRepo.deleteByCartIdProductId(cartUser.getCartId(), productId);
        }
        return deleteSuccess;
    }

    public int updateCartItem(Long userId, Long productId, Long quantity) {
        CartUser cartUser = cartUserRepository.findCartByUserId(userId);
        if (cartUser != null){
            Long cartId = cartUser.getCartId();
            CartProduct cartItem = cartProdRepo.findByCartIdProductId(cartId, productId);
            if (cartItem != null){
                cartItem.setQuantity(quantity);
                cartProdRepo.save(cartItem);
                return 1;
            }
            else{
                CartProduct cartProduct = new CartProduct(cartId, productId, 1, cartUser);
                cartProdRepo.save(cartProduct);
                return 1;
            }
        }
        return 0;
    }

    public Boolean deleteCartByUserId(Long userId) {
        CartUser cartUser = cartUserRepository.findCartByUserId(userId);
        if (cartUser != null){
            Long cartId = cartUser.getCartId();
            int deleteItemCount = cartProdRepo.deleteAllByCartId(cartId);
            if (deleteItemCount>0){
                cartUserRepository.deleteById(cartId);
                return true;
            }
        }
        return false;
    }

    public List<CartProduct> getCartItemsByCartId(Long cartId) {
        return cartProdRepo.findByCartId(cartId);
    }

    public Boolean deleteCartByCartId(Long cartId) {
        int deleteItemCount = cartProdRepo.deleteAllByCartId(cartId);
        if (deleteItemCount>0){
            cartUserRepository.deleteById(cartId);
        }
        return true;
    }
}













