package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.enums.ProductType;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(ProductType productType, int limit, int offset){
        return productRepository.getProductsByCategory(productType.toString(), limit, offset);
    }
}
