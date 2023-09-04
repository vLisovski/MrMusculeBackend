package com.lisovski.mrmuscule.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController {

    @GetMapping(value = "/error")
    public String error() {
        return "Ссылка неверна, либо блокируется CORS...";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
