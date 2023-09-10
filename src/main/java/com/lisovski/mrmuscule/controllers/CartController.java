package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.aspect.LogExecuteTimeAnnotation;
import com.lisovski.mrmuscule.dtos.CartRequestDto;
import com.lisovski.mrmuscule.dtos.CartResponseDto;
import com.lisovski.mrmuscule.models.Cart;
import com.lisovski.mrmuscule.services.CartService;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
@Validated
@Slf4j
public class CartController {

    private CartService cartService;

    @GetMapping("getCart")
    @LogExecuteTimeAnnotation
    public CartResponseDto getCartByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        CartResponseDto cartResponseDto = cartService.getCartProducts(userId);
        log.info("GET CART FOR user_id="+userId+" with products: "+cartResponseDto.getCart());
        return cartResponseDto;
    }

    @GetMapping("getTotal")
    @LogExecuteTimeAnnotation
    public int getTotalCartByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        int total = cartService.getTotalCart(userId);
        log.info("GET CART SIZE FOR user_id="+userId+" with total number of products in cart: "+total);
        return total;
    }

    @PostMapping("addProduct")
    @LogExecuteTimeAnnotation
    public int addProduct(@Valid @RequestBody CartRequestDto cartRequestDto){
       int addedId = cartService.addProduct(cartRequestDto);
       log.info("ADD PRODUCT WITH ID " + cartRequestDto.getProductId() + " TO CART FOR user_id="+cartRequestDto.getUserId());
       return addedId;
    }

    @GetMapping("getProductIds")
    @LogExecuteTimeAnnotation
    public List<Integer> getProductsIds(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        List<Integer> integerList = cartService.getCartProductsIds(userId);
        log.info("GET PRODUCTS IDS: "+integerList+" FOR user_id="+userId);
        return integerList;
    }

    @PostMapping("addCart")
    @LogExecuteTimeAnnotation
    public int addCart(@RequestBody String json){

        System.out.println("json "+json);

        String request1 = json.replace("{","");
        String request2 = request1.replace("}","");
        String request3 = request2.replace("\"","");
        String request4 = request3.replace("carts","");
        String request5 = request4.replace(":","");
        String request6 = request5.replace("[","");
        String request7 = request6.replace("]","");
        String request8 = request7.replace("userId","");
        String request = request8.trim();
        System.out.println("request "+request);
        String[] stringsIds = request.split(",");

        List<Integer> jsonAfterParse = new ArrayList<>();

        for (int i = 0; i < stringsIds.length; i++) {
            jsonAfterParse.add(Integer.parseInt(stringsIds[i]));
        }

        List<Cart> cartList = new ArrayList<>();

        for (int i = 1; i < jsonAfterParse.size(); i++) {
            cartList.add(Cart.builder().userId(jsonAfterParse.get(0)).productId(jsonAfterParse.get(i)).build());
        }

        System.out.println("LIST "+jsonAfterParse);

        return cartService.addAllProducts(cartList);
    }

    @DeleteMapping("deleteProduct")
    @LogExecuteTimeAnnotation
    public void deleteProduct(@Valid @RequestBody CartRequestDto cartRequestDto){
        log.info("DELETE PRODUCT "+cartRequestDto.getProductId()+" FROM CART OF USER WITH user_id="+cartRequestDto.getUserId());
        cartService.deleteProduct(cartRequestDto);
    }

    @DeleteMapping("clearCart")
    @LogExecuteTimeAnnotation
    public void clearCart(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        log.info("CLEAR CART FOR USER WITH user_id="+userId);
        cartService.clearCart(userId);
    }
}
