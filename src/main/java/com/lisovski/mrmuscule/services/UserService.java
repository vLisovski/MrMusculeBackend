package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.dtos.FavoriteProductsResponseDto;
import com.lisovski.mrmuscule.dtos.PurchasedProductsResponseDto;
import com.lisovski.mrmuscule.models.Favorite;
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
        return userOptional.orElseGet(() -> User.builder().id(-1).build());
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public FavoriteProductsResponseDto getFavoritesByUserId(int userId, int limit, int offset){
        Optional<UserFavorite> userFavoriteOptional  = userFavoriteRepository.getFavorites(userId,limit,offset);

        return userFavoriteOptional.isPresent()
                ? modelMapper.map(userFavoriteOptional.get(), FavoriteProductsResponseDto.class)
                : modelMapper.map(UserFavorite.builder().id(-1).build(), FavoriteProductsResponseDto.class);
    }

    public PurchasedProductsResponseDto getPurchasesByUserId(int userId,int limit, int offset){
        Optional<UserPurchases> userPurchasesOptional = userPurchasesRepository.getPurchases(userId,limit,offset);

        return userPurchasesOptional.isPresent()
                ? modelMapper.map(userPurchasesOptional.get(), PurchasedProductsResponseDto.class)
                : modelMapper.map(UserPurchases.builder().id(-1).build(), PurchasedProductsResponseDto.class);
    }

    public int deleteFavorite(Favorite favorite){
        return userRepository.deleteFavorite(favorite.getProductId(),favorite.getUserId());
    }

    public int addFavorite(Favorite favorite){
        try{
            return userRepository.postFavorite(favorite.getProductId(),favorite.getUserId());
        }catch (Exception e){
            System.out.println("duplicate key value violates unique constraint \"favorite_product_id_user_id_uindex\"");
            return 0;
        }
    }
}
