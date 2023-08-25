package com.lisovski.mrmuscule.dtos;

import com.lisovski.mrmuscule.models.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCartRequestDto {
    private List<Cart> carts;
}
