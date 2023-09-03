package com.lisovski.mrmuscule.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAspect {

    @ExceptionHandler(Exception.class)
    public int handleException(Exception e) {
        System.out.println("ERROR " + e.getMessage());
        return -1;
    }

}
