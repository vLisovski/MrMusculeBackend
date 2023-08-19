package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserFavoriteRepository extends JpaRepository<Favorite, Integer> {

    @Query(value = "SELECT * FROM favorite WHERE user_id=:user_id ORDER BY product_id LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Favorite> getFavorites(@Param(value = "user_id") int userId,
                                    @Param(value = "limit") int limit,
                                    @Param(value = "offset") int offset);
}
