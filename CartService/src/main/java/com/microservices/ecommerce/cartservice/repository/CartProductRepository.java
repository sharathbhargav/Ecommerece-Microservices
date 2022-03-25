package com.microservices.ecommerce.cartservice.repository;

import com.microservices.ecommerce.cartservice.entity.CartProduct;
import com.microservices.ecommerce.cartservice.entity.CartProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface CartProductRepository extends JpaRepository<CartProduct, CartProductId> {

    @Query(
            value = "SELECT * FROM cart_product c WHERE c.cart_id = ?1",
            nativeQuery = true
    )
    Optional<List<CartProduct>> findByCartId(Long cartId);

    @Modifying
    @Query(
            value = "DELETE FROM cart_product c WHERE c.cart_id = ?1 AND c.product_id = ?2",
            nativeQuery = true
    )
    long deleteByCartIdProductId(Long cartId, Long productId);

    @Query(
            value = "SELECT * FROM cart_product c WHERE c.cart_id = :cartId AND c.product_id = :productId",
            nativeQuery = true
    )
    Optional<CartProduct> findByCartIdProductId(Long cartId, Long productId);

    @Modifying
    @Query(
            value = "DELETE FROM cart_product c WHERE c.cart_id = :cartId",
            nativeQuery = true
    )
    long deleteAllByCartId(Long cartId);
}
