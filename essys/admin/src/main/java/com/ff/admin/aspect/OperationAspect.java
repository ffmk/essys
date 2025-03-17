package com.ff.admin.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.ff.admin.annotation.GlobalInterceptor;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class OperationAspect {

    @Before("@annotation(com.ff.admin.annotation.GlobalInterceptor)")
    public void InterceptorDo(JoinPoint point) {
        Object[] args = point.getArgs();
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        GlobalInterceptor interceptor = method.getAnnotation(GlobalInterceptor.class);
        if (interceptor == null) {
            return;
        }

        
    }
}
