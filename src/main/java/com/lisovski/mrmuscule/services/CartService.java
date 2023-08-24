package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.dtos.CartRequestDto;
import com.lisovski.mrmuscule.dtos.CartResponseDto;
import com.lisovski.mrmuscule.models.Cart;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.repositories.CartRepository;
import com.lisovski.mrmuscule.repositories.ProductRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public CartResponseDto getCartProducts(int userId, int limit, int offset) {
        List<Product> productList = productRepository.getCartProducts(userId, limit, offset);
        return CartResponseDto.builder().cart(productList).build();
    }

    public int getTotalCart(int userId){
        return cartRepository.getTotalCartByUserId(userId);
    }


    public int deleteProduct(CartRequestDto cartRequestDto) {
        return cartRepository.deleteProductFromCart(cartRequestDto.getUserId(), cartRequestDto.getProductId());
    }

    public int addProduct(CartRequestDto cartRequestDto) {
        return cartRepository.addProductToCart(cartRequestDto.getUserId(), cartRequestDto.getProductId());
    }

    public int clearCart(int userId) {
        return cartRepository.clearCart(userId);
    }
}
