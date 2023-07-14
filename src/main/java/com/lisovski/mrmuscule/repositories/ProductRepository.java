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

    @Query(value="SELECT p.id,pro.name,pro.description,pro.price,pro.type,pro.photo_path\n" +
            "FROM products pro JOIN purchases pur ON pro.id = pur.product_id AND pur.user_id=:userId",nativeQuery = true)
    List<Product> getPurchases(@Param("userId") int userId);

    @Query(value="SELECT * FROM products WHERE type = cast(:type as product_type) LIMIT :limit OFFSET :offset",nativeQuery = true)
    List<Product> getProductsByCategory(@Param(value = "type") String productType,
                                        @Param(value = "limit") int limit,
                                        @Param(value = "offset") int offset);
}
