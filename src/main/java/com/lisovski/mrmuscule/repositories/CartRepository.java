package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "DELETE FROM cart WHERE user_id = :user_id",nativeQuery = true)
    void clearCart(@Param(value = "user_id")int userId);
}
