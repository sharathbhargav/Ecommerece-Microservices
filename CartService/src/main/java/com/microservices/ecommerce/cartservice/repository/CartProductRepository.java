package com.microservices.ecommerce.cartservice.repository;

import com.microservices.ecommerce.cartservice.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

    @Query(
            value = "SELECT * FROM cart_product c WHERE c.cart_id = ?1",
            nativeQuery = true
    )
    List<CartProduct> findByCartId(Long cartId);

    @Modifying
    @Query(
            value = "DELETE FROM cart_product c WHERE c.cart_id = ?1 AND c.product_id = ?2",
            nativeQuery = true
    )
    int deleteByCartIdProductId(Long cartId, Long productId);

    @Query(
            value = "SELECT * FROM cart_product c WHERE c.cart_id = :cartId AND c.product_id = :productId",
            nativeQuery = true
    )
    CartProduct findByCartIdProductId(Long cartId, Long productId);

    @Modifying
    @Query(
            value = "DELETE FROM cart_product c WHERE c.cart_id = :cartId",
            nativeQuery = true
    )
    int deleteAllByCartId(Long cartId);
}
