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

    public List<Product> getFavoritesByUserId(int userId, int limit, int offset){
        return productRepository.getFavoritesProducts(userId,limit,offset);
    }

    public int getTotalInventory(){
        return productRepository.getTotalByProductType(ProductType.inventory.toString());
    }

    public int getTotalFood(){
        return productRepository.getTotalByProductType(ProductType.food.toString());
    }

    public int getTotalClothes(){
        return productRepository.getTotalByProductType(ProductType.clothes.toString());
    }

    public List<Product> getProductsByIds(List<Integer> ids){
        return productRepository.findAllById(ids);
    }

    public int getTotalByTags(String tag1, String tag2){

        if(tag1.contains("cardio")){
            tag1="%"+tag1;
        }
        System.out.println("SERVICE TOTAL TAGS "+productRepository.getTotalByTags(tag1,tag2));
        return productRepository.getTotalByTags(tag1,tag2);
    }

    public List<Product> getProductsByTag(String tag1, String tag2, int limit, int offset){
        if(tag1.contains("cardio")){
            tag1="%"+tag1;
        }
        return productRepository.getProductsByTags(tag1,tag2,limit,offset);
    }
}
