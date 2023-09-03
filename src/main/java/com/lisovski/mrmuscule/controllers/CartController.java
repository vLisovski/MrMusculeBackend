package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.aspect.LogExecuteTimeAnnotation;
import com.lisovski.mrmuscule.dtos.CartRequestDto;
import com.lisovski.mrmuscule.dtos.CartResponseDto;
import com.lisovski.mrmuscule.dtos.AddCartRequestDto;
import com.lisovski.mrmuscule.models.Cart;
import com.lisovski.mrmuscule.services.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
@Validated
public class CartController {

    private CartService cartService;

    @GetMapping("getCart")
    @LogExecuteTimeAnnotation
    public CartResponseDto getCartByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return cartService.getCartProducts(userId);
    }

    @GetMapping("getTotal")
    @LogExecuteTimeAnnotation
    public int getTotalCartByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return cartService.getTotalCart(userId);
    }

    @PostMapping("addProduct")
    @LogExecuteTimeAnnotation
    public int addProduct(@Valid @RequestBody CartRequestDto cartRequestDto){
       return cartService.addProduct(cartRequestDto);
    }

    @GetMapping("getProductIds")
    @LogExecuteTimeAnnotation
    public List<Integer> getProductsIds(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return cartService.getCartProductsIds(userId);
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
        cartService.deleteProduct(cartRequestDto);
    }

    @DeleteMapping("clearCart")
    @LogExecuteTimeAnnotation
    public void clearCart(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        cartService.clearCart(userId);
    }
}
