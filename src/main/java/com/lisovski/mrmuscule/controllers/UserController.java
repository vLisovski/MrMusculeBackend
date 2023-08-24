package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.dtos.*;
import com.lisovski.mrmuscule.models.Favorite;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.models.User;
import com.lisovski.mrmuscule.services.ProductService;
import com.lisovski.mrmuscule.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
@Validated
public class UserController {

    private UserService userService;
    private ProductService productService;

    @GetMapping("getById")
    public UserResponseDto getById(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return userService.getById(userId);
    }

    @GetMapping("getTotalPurchases")
    public int getTotalPurchasesByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return userService.getTotalPurchases(userId);
    }

    @GetMapping("getBonusBalance")
    public int getBonusBalanceByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return userService.getBonusBalanceByUserId(userId);
    }

    @GetMapping("updateEmail")
    public int updateEmail(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                           @NotNull @RequestParam String email){
        return userService.UpdateEmailByUserId(userId, email);
    }

    @GetMapping("updateName")
    public int updateName(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                           @NotNull @RequestParam String name){
        return userService.UpdateNameNyUserId(userId, name);
    }

    @GetMapping("updatePhoneNumber")
    public int updatePhoneNumber(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                           @NotNull @RequestParam String phoneNumber){
        return userService.UpdatePhoneNumberByUserId(userId, phoneNumber);
    }

    @GetMapping("updatePhotoPath")
    public int updateAvatarPath(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                           @NotNull @RequestParam String avatarPath){
        return userService.UpdateAvatarPathByUserId(userId, avatarPath);
    }

    @GetMapping("getIdByToken")
    public int getIdByToken(Principal principal){
        return  userService.findByEmail(principal.getName()).get().getId();
    }

    @GetMapping("getFavoritesIds")
    public List<Integer> getFavoritesIdsByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                                          @Min(1) @Max(16) @NotNull @RequestParam int limit,
                                          @Min(0) @Max(2147483631) @NotNull @RequestParam int offset){
        return userService.getFavoritesIdsByUserId(userId, limit, offset);
    }

    @GetMapping("getFavorites")
    public List<Product> getFavoritesByIdUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                                                @Min(1) @Max(16) @NotNull @RequestParam int limit,
                                                @Min(0) @Max(2147483631) @NotNull @RequestParam int offset){
        return productService.getFavoritesByUserId(userId, limit, offset);
    }

    @GetMapping("getTotalFavorite")
    public int getTotalByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
       return userService.getTotalFavoritesByUserId(userId);
    }

    @GetMapping("getPurchases")
    public PurchasedProductsResponseDto getPurchasesById(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                                                         @Min(1) @Max(16) @NotNull @RequestParam int limit,
                                                         @Min(0) @Max(2147483631) @NotNull @RequestParam int offset){
        return userService.getPurchasesByUserId(userId,limit,offset);
    }

    @PostMapping("addFavorite")
    public int addFavorite(@Valid @RequestBody FavoriteProductsRequestDto favoriteProductsRequestDto){
       return userService.addFavorite(favoriteProductsRequestDto);
    }

    @DeleteMapping("deleteFavorite")
    public int deleteFavorite(@Valid @RequestBody FavoriteProductsRequestDto favoriteProductsRequestDto){
       return userService.deleteFavorite(favoriteProductsRequestDto);
    }
}
