package com.lisovski.mrmuscule.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FavoriteProductsResponseDto {
    private List<Integer> favoriteList;
}
