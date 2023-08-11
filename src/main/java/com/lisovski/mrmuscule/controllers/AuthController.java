package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.authservices.AuthOrRegisterService;
import com.lisovski.mrmuscule.dtos.AuthOrRegisterResponseDto;
import com.lisovski.mrmuscule.dtos.AuthRequestDto;
import com.lisovski.mrmuscule.dtos.RegisterRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
    private final AuthOrRegisterService authOrRegisterService;

    @PostMapping("/register")
    public AuthOrRegisterResponseDto register(@RequestBody RegisterRequestDto registerRequestDto) {
        return authOrRegisterService.register(registerRequestDto);
    }

    @PostMapping("/authenticate")
    public AuthOrRegisterResponseDto authenticate(@RequestBody AuthRequestDto authRequestDto) {
        return authOrRegisterService.authenticate(authRequestDto);
    }
}
