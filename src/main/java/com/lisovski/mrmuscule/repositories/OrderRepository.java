package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "INSERT INTO orders (date,cost,description,user_id,status) " +
            "VALUES (:date,:cost,:description,:user_id,cast(:status as order_status)) RETURNING orders.id",nativeQuery = true)
    int saveOrder(@Param(value = "date") Date date,
                  @Param(value = "cost") int cost,
                  @Param(value = "description") String description,
                  @Param(value = "user_id") int user_id,
                  @Param(value = "status") String status
    );

    void deleteByUser_id(int userId);


}
