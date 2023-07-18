package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.UserFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Integer> {
}
