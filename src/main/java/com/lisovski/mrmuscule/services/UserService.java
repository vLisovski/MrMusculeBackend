package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.dtos.FavoriteProductsRequestDto;
import com.lisovski.mrmuscule.dtos.PurchasedProductsResponseDto;
import com.lisovski.mrmuscule.dtos.UserResponseDto;
import com.lisovski.mrmuscule.models.*;
import com.lisovski.mrmuscule.repositories.ProductRepository;
import com.lisovski.mrmuscule.repositories.UserFavoriteRepository;
import com.lisovski.mrmuscule.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserFavoriteRepository userFavoriteRepository;
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public UserResponseDto getById(int userId){

        Optional<User> userOptional = userRepository.findById(userId);
        UserResponseDto userResponseDto = new UserResponseDto();
        if(userOptional.isPresent()){
            User user = userOptional.get();

            userResponseDto = modelMapper.map(user, UserResponseDto.class);
        }

        return userResponseDto;
    }

    public int getBonusBalanceByUserId(int userId){
        return userRepository.getBonusBalanceByUserId(userId);
    }

    public int updateBonusBalance(int bonuses, int userId){
        return  userRepository.updateBonusesByUserId(bonuses, userId);
    }

    public int getTotalPurchases(int userId){
        return userRepository.getTotalPurchasesByUserId(userId);
    }



    public int UpdateNameNyUserId(int userId, String name){
      return userRepository.UpdateNameNyUserId(userId, name);
    }

    public int UpdatePhoneNumberByUserId(int userId, String phoneNumber){
        return userRepository.UpdatePhoneNumberByUserId(userId, phoneNumber);
    }

    public int UpdateEmailByUserId(int userId, String email){
        return userRepository.UpdateEmailByUserId(userId, email);
    }

    public int UpdateAvatarPathByUserId(int userId, String avatarPath){
        return userRepository.UpdateAvatarPathByUserId(userId, avatarPath);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<Integer> getFavoritesIdsByUserId(int userId, int limit, int offset){
        List<Favorite> favoriteList = userFavoriteRepository.getFavorites(userId,limit,offset);

        List<Integer> favoriteIds = new ArrayList<>();
        if(!favoriteList.isEmpty()){
            favoriteIds = favoriteList.stream().map(Favorite::getProductId).collect(Collectors.toList());
        }

        return favoriteIds;
    }

    public int getTotalFavoritesByUserId(int userId){
       return userFavoriteRepository.getTotalByUserId(userId);
    }

    public PurchasedProductsResponseDto getPurchasesByUserId(int userId,int limit, int offset){
        List<Product> userPurchases = productRepository.getPurchases(userId,limit,offset);

        return PurchasedProductsResponseDto.builder().purchasesList(userPurchases).build();
    }

    public int deleteFavorite(FavoriteProductsRequestDto favoriteProductsRequestDto){
        return userRepository.deleteFavorite(favoriteProductsRequestDto.getProductId(),favoriteProductsRequestDto.getUserId());
    }

    public int addFavorite(FavoriteProductsRequestDto favoriteProductsRequestDto){
        try{
            return userRepository.postFavorite(favoriteProductsRequestDto.getProductId(),
                    favoriteProductsRequestDto.getUserId());
        }catch (Exception e){
            System.out.println("duplicate key value violates unique constraint \"favorite_product_id_user_id_uindex\"");
            return 0;
        }
    }
}
