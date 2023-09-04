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
