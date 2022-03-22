package com.microservices.ecommerce.cartservice.repository;

import com.microservices.ecommerce.cartservice.entity.CartUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartUserRepository extends JpaRepository<CartUser, Long> {

    @Query(
            value = "select * from cart_user c where c.user_id = ?1",
            nativeQuery = true
    )
    CartUser findCartByUserId(Long userId);

}
