package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.dtos.CartRequestDto;
import com.lisovski.mrmuscule.dtos.CartResponseDto;
import com.lisovski.mrmuscule.models.Cart;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.repositories.CartRepository;
import com.lisovski.mrmuscule.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public CartResponseDto getCartProducts(int userId) {
        List<Product> productList = productRepository.getCartProducts(userId);
        return CartResponseDto.builder().cart(productList).build();
    }

    public int getTotalCart(int userId){
        return cartRepository.getTotalCartByUserId(userId);
    }

    public List<Integer> getCartProductsIds(int userId){
        return cartRepository.getCartProductsIds(userId);
    }

    public int deleteProduct(CartRequestDto cartRequestDto) {
        return cartRepository.deleteProductFromCart(cartRequestDto.getUserId(), cartRequestDto.getProductId());
    }

    public int addProduct(CartRequestDto cartRequestDto) {
        int count = 0;
        try{
            count = cartRepository.addProductToCart(cartRequestDto.getUserId(), cartRequestDto.getProductId());
        }catch (Exception e){
            return count;
        }
        return count;
    }

    public int addAllProducts(List<Cart> cartList){
        cartRepository.saveAll(cartList);
        return 1;
    }

    public int clearCart(int userId) {
        return cartRepository.clearCart(userId);
    }
}
