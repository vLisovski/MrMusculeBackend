package com.lisovski.mrmuscule.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private String phoneNumber;

    private String email;

    private String name;

    private String avatarPath;
}
