package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "DELETE FROM favorite WHERE product_id=:product_id AND user_id=:user_id RETURNING *", nativeQuery = true)
    int deleteFavorite(@Param(value = "product_id") int productId,
                                @Param(value = "user_id") int userId);

    @Query(value = "INSERT INTO favorite (user_id, product_id) VALUES (:user_id,:product_id) RETURNING *",nativeQuery = true)
    int postFavorite(@Param(value = "product_id") int productId,
                      @Param(value = "user_id") int userId);

    Optional<User> findByEmail(String email);
}
