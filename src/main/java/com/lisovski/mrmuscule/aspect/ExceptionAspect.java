package com.lisovski.mrmuscule.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAspect {

    @ExceptionHandler(Exception.class)
    public Exception handleException(Exception e) {
        System.out.println("ERROR " + e.getMessage());
        log.error("ERROR FROM ASPECT" + e.getMessage());
        return e;
    }

}
