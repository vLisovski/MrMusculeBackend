package com.lisovski.mrmuscule.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    @Email
    private String email;
    @Pattern(regexp = ".{16}")
    private String password;
}
