package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.aspect.LogExecuteTimeAnnotation;
import com.lisovski.mrmuscule.authservices.AuthOrRegisterService;
import com.lisovski.mrmuscule.dtos.AuthOrRegisterResponseDto;
import com.lisovski.mrmuscule.dtos.AuthRequestDto;
import com.lisovski.mrmuscule.dtos.RegisterRequestDto;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("free/auth")
@AllArgsConstructor
@Validated
@Slf4j
public class AuthController {
    private final AuthOrRegisterService authOrRegisterService;

    @PostMapping("/register")
    @LogExecuteTimeAnnotation
    public AuthOrRegisterResponseDto register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        log.info("REGISTER USER WITH email="+registerRequestDto.getEmail()+" AND password=****************");
        return authOrRegisterService.register(registerRequestDto);
    }

    @PostMapping("/authenticate")
    @LogExecuteTimeAnnotation
    public AuthOrRegisterResponseDto authenticate(@Valid @RequestBody AuthRequestDto authRequestDto) {
        log.info("AUTHORIZE USER WITH email="+authRequestDto.getEmail()+" AND password=****************");
        return authOrRegisterService.authenticate(authRequestDto);
    }

}
