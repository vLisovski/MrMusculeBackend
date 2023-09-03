package com.lisovski.mrmuscule.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class LogExecuteTimeAspect {
    @Around("@annotation(LogExecuteTimeAnnotation)")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();

        Object proceed = joinPoint.proceed();

        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toNanos(endTime - startTime);

        System.out.println(joinPoint.getSignature() + " executed in " + duration + "ns");

        return proceed;
    }
}
