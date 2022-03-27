package com.microservices.ecommerce.cartservice.service;

import com.microservices.ecommerce.cartservice.entity.CartProduct;
import com.microservices.ecommerce.cartservice.entity.CartProductId;
import com.microservices.ecommerce.cartservice.entity.CartUser;
import com.microservices.ecommerce.cartservice.repository.CartProductRepository;
import com.microservices.ecommerce.cartservice.repository.CartUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartUserRepository cartUserRepository;
    @Autowired
    private CartProductRepository cartProductRepository;


    public List<CartProduct> getCartItemsByUserId(Long userId) throws Exception {
        Optional<CartUser> cartUser = cartUserRepository.findCartByUserId(userId);
        Optional<List<CartProduct>> cartItems;
        if (cartUser.isPresent()){
            Long cartId = cartUser.get().getCartId();
            cartItems = cartProductRepository.findByCartId(cartId);
            if (cartItems.isPresent()){
                return cartItems.get();
            }
            else{
                throw new Exception("No items for the cart");
            }
        }
        return null;
    }

    public long deleteCartItem(Long userId, Long productId) {
        Optional<CartUser> cartUser = cartUserRepository.findCartByUserId(userId);
        if (cartUser.isPresent()){
            Long cartId = cartUser.get().getCartId();
            long numRecordsDeleted = cartProductRepository.deleteByCartIdProductId(cartId, productId);
            return numRecordsDeleted;
        }
        return 0;
    }

    public CartProduct updateCartItem(Long userId, Long productId, Long quantity) {
        Optional<CartUser> cartUser = cartUserRepository.findCartByUserId(userId);
        if (cartUser.isPresent()){
            Long cartId = cartUser.get().getCartId();
            Optional<CartProduct> cartItemOptional = cartProductRepository.findByCartIdProductId(cartId, productId);
            if (cartItemOptional.isPresent()){
                CartProduct cartProduct = cartItemOptional.get();
                cartProduct.setQuantity(quantity);
                CartProduct response = cartProductRepository.save(cartProduct);
                return response;
            }
            else{
                CartProductId cartProductId = new CartProductId(cartId, productId);
                CartProduct cartProduct = new CartProduct(cartProductId, quantity, cartUser.get());
                CartProduct response = cartProductRepository.save(cartProduct);
                return response;
            }
        }
        else{
            //TODO: change 1 below later
            CartUser cartUser1 = new CartUser(1,userId);
            CartUser savedUser = cartUserRepository.save(cartUser1);
            CartProductId cartProductId = new CartProductId(savedUser.getCartId(), productId);
            CartProduct cartProduct = new CartProduct(cartProductId, quantity, savedUser);
            CartProduct response = cartProductRepository.save(cartProduct);
            return response;
        }
    }

    public long deleteCartByUserId(Long userId) {
        Optional<CartUser> cartUser = cartUserRepository.findCartByUserId(userId);
        if (cartUser.isPresent()){
            Long cartId = cartUser.get().getCartId();
            long deleteItemCountProduct = cartProductRepository.deleteAllByCartId(cartId);
            cartUserRepository.deleteById(cartId);
            return deleteItemCountProduct;
        }
        return 0;
    }

    public List<CartProduct> getCartItemsByCartId(Long cartId) throws Exception {
        Optional<List<CartProduct>> cartProducts = cartProductRepository.findByCartId(cartId);
        if (cartProducts.isPresent()){
            return cartProducts.get();
        }
        else{
            throw new Exception("No items found for cartId: "+cartId);
        }
    }

    public long deleteCartByCartId(Long cartId) {
        long deleteItemCount = cartProductRepository.deleteAllByCartId(cartId);
        cartUserRepository.deleteById(cartId);
        return deleteItemCount;
    }
}













