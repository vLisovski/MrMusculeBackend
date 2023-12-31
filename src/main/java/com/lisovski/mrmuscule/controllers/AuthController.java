package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.aspect.LogExecuteTimeAnnotation;
import com.lisovski.mrmuscule.authservices.AuthOrRegisterService;
import com.lisovski.mrmuscule.dtos.AuthOrRegisterResponseDto;
import com.lisovski.mrmuscule.dtos.AuthRequestDto;
import com.lisovski.mrmuscule.dtos.RegisterRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("free/auth")
@AllArgsConstructor
@Validated
public class AuthController {
    private final AuthOrRegisterService authOrRegisterService;

    @PostMapping("/register")
    @LogExecuteTimeAnnotation
    public AuthOrRegisterResponseDto register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        return authOrRegisterService.register(registerRequestDto);
    }

    @PostMapping("/authenticate")
    @LogExecuteTimeAnnotation
    public AuthOrRegisterResponseDto authenticate(@Valid @RequestBody AuthRequestDto authRequestDto) {
        return authOrRegisterService.authenticate(authRequestDto);
    }

}
