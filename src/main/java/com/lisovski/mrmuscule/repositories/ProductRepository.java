package com.lisovski.mrmuscule.repositories;

import com.lisovski.mrmuscule.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT p.id,p.name,p.description,p.price,p.type,p.photo_path FROM products p " +
            "JOIN favorite f " +
            "ON p.id = f.product_id AND f.user_id=:userId",nativeQuery = true)
    List<Product> getFavorite(@Param("userId") int userId);
}
