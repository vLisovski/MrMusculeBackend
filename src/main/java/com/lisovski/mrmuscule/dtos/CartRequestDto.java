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
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {

    @NotNull
    @Min(0)
    @Max(2147483647)
    int userId;

    @NotNull
    @Min(0)
    @Max(2147483647)
    int productId;
}
