package com.ff.admin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OperationAspect {

    @Before("@annotation(com.ff.admin.annotation.GlobalInterceptor)")
    public void InterceptorDo(JoinPoint point) {
        System.out.println("进入切面");
    }
}
