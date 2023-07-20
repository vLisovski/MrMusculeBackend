package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.OrdersProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersProductsRepository extends JpaRepository<OrdersProducts,Integer> {
}
