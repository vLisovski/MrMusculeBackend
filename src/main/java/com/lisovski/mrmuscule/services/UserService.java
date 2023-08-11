package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.dtos.FavoriteProductsResponseDto;
import com.lisovski.mrmuscule.dtos.PurchasedProductsResponseDto;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.models.User;
import com.lisovski.mrmuscule.models.UserFavorite;
import com.lisovski.mrmuscule.models.UserPurchases;
import com.lisovski.mrmuscule.repositories.UserFavoriteRepository;
import com.lisovski.mrmuscule.repositories.UserPurchasesRepository;
import com.lisovski.mrmuscule.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserFavoriteRepository userFavoriteRepository;
    private UserPurchasesRepository userPurchasesRepository;
    private ModelMapper modelMapper;

    public User getById(int userId){
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.isPresent() ? userOptional.get() : User.builder().id(-1).build();
    }

    public FavoriteProductsResponseDto getFavoritesByUserId(int userId){
        UserFavorite userFavorite  = userFavoriteRepository.findById(userId).get();
        return modelMapper.map(userFavorite, FavoriteProductsResponseDto.class);
    }

    public PurchasedProductsResponseDto getPurchasesByUserId(int userId){
        UserPurchases userPurchases = userPurchasesRepository.findById(userId).get();
        return modelMapper.map(userPurchases, PurchasedProductsResponseDto.class);
    }

    public int deleteFavorite(int productId, int userId){
        return userRepository.deleteFavorite(productId,userId);
    }

    public int addFavorite(int productId, int userId){
        try{
            return userRepository.postFavorite(productId,userId);
        }catch (Exception e){
            System.out.println("duplicate key value violates unique constraint \"favorite_product_id_user_id_uindex\"");
            return 0;
        }
    }
}
