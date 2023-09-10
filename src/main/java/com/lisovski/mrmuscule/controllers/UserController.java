package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.aspect.LogExecuteTimeAnnotation;
import com.lisovski.mrmuscule.dtos.*;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.services.ProductService;
import com.lisovski.mrmuscule.services.UserService;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
@Validated
@Slf4j
public class UserController {

    private UserService userService;
    private ProductService productService;


    @GetMapping("getById")
    @LogExecuteTimeAnnotation
    public UserResponseDto getById(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        log.info("GET USER WITH id="+userId);
        return userService.getById(userId);
    }

    @GetMapping("getTotalPurchases")
    @LogExecuteTimeAnnotation
    public int getTotalPurchasesByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        log.info("GET TOTAL NUMBER OF PURCHASES FOR USER WITH id="+userId);
        return userService.getTotalPurchases(userId);
    }

    @GetMapping("getBonusBalance")
    @LogExecuteTimeAnnotation
    public int getBonusBalanceByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        log.info("GET BONUS BALANCE FOR USER WITH id="+userId);
        return userService.getBonusBalanceByUserId(userId);
    }

    @GetMapping("updateBonusBalance")
    @LogExecuteTimeAnnotation
    public int updateBonusBalanceByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int bonuses,
                                          @Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        log.info("UPDATE BONUS BALANCE FOR USER WITH id="+userId+"to bonuses="+bonuses);
        return userService.updateBonusBalance(bonuses, userId);
    }

    @GetMapping("updateEmail")
    @LogExecuteTimeAnnotation
    public int updateEmail(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                           @NotNull @RequestParam String email){
        log.info("UPDATE EMAIL FOR USER WITH id="+userId+"to email="+email);
        return userService.UpdateEmailByUserId(userId, email);
    }

    @GetMapping("updateName")
    @LogExecuteTimeAnnotation
    public int updateName(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                           @NotNull @RequestParam String name){
        log.info("UPDATE NAME FOR USER WITH id="+userId+"to name="+name);
        return userService.UpdateNameNyUserId(userId, name);
    }

    @GetMapping("updatePhoneNumber")
    @LogExecuteTimeAnnotation
    public int updatePhoneNumber(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                           @NotNull @RequestParam String phoneNumber){
        log.info("UPDATE PHONE NUMBER FOR USER WITH id="+userId+"to phone_number="+phoneNumber);
        return userService.UpdatePhoneNumberByUserId(userId, phoneNumber);
    }

    @GetMapping("updatePhotoPath")
    @LogExecuteTimeAnnotation
    public int updateAvatarPath(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                           @NotNull @RequestParam String avatarPath){
        log.info("UPDATE AVATAR URL FOR USER WITH id="+userId+"to avatar_url="+avatarPath);
        return userService.UpdateAvatarPathByUserId(userId, avatarPath);
    }

    @GetMapping("getIdByToken")
    @LogExecuteTimeAnnotation
    public int getIdByToken(Principal principal){
        int userId = userService.findByEmail(principal.getName()).get().getId();
        log.info("GET ID BY TOKEN FOR USER WITH id="+userId);
        return userId;
    }

    @GetMapping("getFavoritesIds")
    @LogExecuteTimeAnnotation
    public List<Integer> getFavoritesIdsByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                                          @Min(1) @Max(16) @NotNull @RequestParam int limit,
                                          @Min(0) @Max(2147483631) @NotNull @RequestParam int offset){
        log.info("GET FAVORITE PRODUCTS IDS FOR USER WITH id="+userId+" ,limit="+limit+" AND offset="+offset);
        return userService.getFavoritesIdsByUserId(userId, limit, offset);
    }

    @GetMapping("getFavorites")
    @LogExecuteTimeAnnotation
    public List<Product> getFavoritesByIdUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                                                @Min(1) @Max(16) @NotNull @RequestParam int limit,
                                                @Min(0) @Max(2147483631) @NotNull @RequestParam int offset){
        log.info("GET FAVORITE PRODUCTS FOR USER WITH id="+userId+" ,limit="+limit+" AND offset="+offset);
        return productService.getFavoritesByUserId(userId, limit, offset);
    }

    @GetMapping("getTotalFavorite")
    @LogExecuteTimeAnnotation
    public int getTotalByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
       log.info("GET TOTAL NUMBER OF FAVORITE PRODUCTS FOR USER WITH user_id="+userId);
       return userService.getTotalFavoritesByUserId(userId);
    }

    @GetMapping("getPurchases")
    @LogExecuteTimeAnnotation
    public PurchasedProductsResponseDto getPurchasesById(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                                                         @Min(1) @Max(16) @NotNull @RequestParam int limit,
                                                         @Min(0) @Max(2147483631) @NotNull @RequestParam int offset){
        log.info("GET PURCHASES FOR USER WITH id="+userId+" ,limit="+limit+" AND offset="+offset);
        return userService.getPurchasesByUserId(userId,limit,offset);
    }

    @PostMapping("addFavorite")
    @LogExecuteTimeAnnotation
    public int addFavorite(@Valid @RequestBody FavoriteProductsRequestDto favoriteProductsRequestDto){
       log.info("ADD FAVORITE PRODUCT WITH id="+favoriteProductsRequestDto.getProductId()+" FOR USER WITH id="+favoriteProductsRequestDto.getUserId());
       return userService.addFavorite(favoriteProductsRequestDto);
    }

    @DeleteMapping("deleteFavorite")
    @LogExecuteTimeAnnotation
    public int deleteFavorite(@Valid @RequestBody FavoriteProductsRequestDto favoriteProductsRequestDto){
       log.info("DELETE FAVORITE PRODUCT WITH id="+favoriteProductsRequestDto.getProductId()+" FOR USER WITH id="+favoriteProductsRequestDto.getUserId());
       return userService.deleteFavorite(favoriteProductsRequestDto);
    }
}
