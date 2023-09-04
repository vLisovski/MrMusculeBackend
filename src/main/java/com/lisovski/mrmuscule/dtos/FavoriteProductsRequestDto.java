package com.lisovski.mrmuscule.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
