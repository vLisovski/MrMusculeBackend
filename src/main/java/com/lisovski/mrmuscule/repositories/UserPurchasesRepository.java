package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.UserFavorite;
import com.lisovski.mrmuscule.models.UserPurchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserPurchasesRepository extends JpaRepository<UserPurchases, Integer> {

}
