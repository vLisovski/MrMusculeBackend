package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {

}
