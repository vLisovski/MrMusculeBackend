package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.UserPurchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPurchasesRepository extends JpaRepository<UserPurchases, Integer> {

}
