package com.lisovski.mrmuscule.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteProductsRequestDto {
    @NotNull
    @Min(1)
    @Max(2147483647)
    int productId;

    @NotNull
    @Min(1)
    @Max(2147483647)
    int userId;
}
