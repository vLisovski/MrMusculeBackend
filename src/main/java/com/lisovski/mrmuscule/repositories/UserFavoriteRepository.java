package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.UserFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Integer> {

    @Query(value = "SELECT * FROM favorite WHERE user_id=:user_id LIMIT :limit OFFSET :offset", nativeQuery = true)
    Optional<UserFavorite>  getFavorites(@Param(value = "user_id") int userId,
                                           @Param(value = "limit") int limit,
                                           @Param(value = "offset") int offset);
}
