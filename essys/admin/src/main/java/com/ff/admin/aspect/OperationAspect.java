package com.ff.admin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class OperationAspect {

    @Before("@annotation(com.ff.admin.annotation.GlobalInterceptor)")
    public void InterceptorDo(JoinPoint point) {
        System.out.println("before check");

    }
}
