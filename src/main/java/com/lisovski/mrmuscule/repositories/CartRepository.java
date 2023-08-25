package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "DELETE FROM cart WHERE user_id=:user_id RETURNING 1",nativeQuery = true)
    int clearCart(@Param(value = "user_id")int userId);

    @Query(value="DELETE FROM cart WHERE user_id=:user_id AND product_id=:product_id RETURNING 1", nativeQuery = true)
    int deleteProductFromCart(@Param(value = "user_id")int userId,
                              @Param(value = "product_id")int productId);

    @Query(value="INSERT INTO cart (user_id, product_id) VALUES (:user_id, :product_id)", nativeQuery = true)
    int addProductToCart(@Param(value = "user_id") int userId,
                              @Param(value = "product_id") int productId);

    @Query(value = "SELECT COUNT(*) FROM cart WHERE user_id=:userId",nativeQuery = true)
    int getTotalCartByUserId(@Param(value = "userId") int userId);

    @Query(value="SELECT product_id FROM cart WHERE user_id=:userId", nativeQuery = true)
    List<Integer> getCartProductsIds(@Param(value = "userId") int userId);

}
