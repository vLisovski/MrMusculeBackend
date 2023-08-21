package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.dtos.FavoriteProductsRequestDto;
import com.lisovski.mrmuscule.dtos.PurchasedProductsResponseDto;
import com.lisovski.mrmuscule.dtos.UserResponseDto;
import com.lisovski.mrmuscule.models.*;
import com.lisovski.mrmuscule.repositories.UserFavoriteRepository;
import com.lisovski.mrmuscule.repositories.UserPurchasesRepository;
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
    private UserPurchasesRepository userPurchasesRepository;
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
        Optional<UserPurchases> userPurchasesOptional = userPurchasesRepository.getPurchases(userId,limit,offset);

        return userPurchasesOptional.isPresent()
                ? modelMapper.map(userPurchasesOptional.get(), PurchasedProductsResponseDto.class)
                : modelMapper.map(UserPurchases.builder().id(-1).build(), PurchasedProductsResponseDto.class);
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
