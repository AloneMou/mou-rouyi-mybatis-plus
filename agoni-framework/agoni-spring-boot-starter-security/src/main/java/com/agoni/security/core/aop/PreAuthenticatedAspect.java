package com.agoni.security.core.aop;

import com.agoni.security.core.annotations.PreAuthenticated;
import com.agoni.security.core.util.SecurityUserUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import static com.agoni.exception.enums.GlobalErrorCodeConstants.UNAUTHORIZED;
import static com.agoni.exception.util.ServiceExceptionUtil.exception;


@Aspect
@Slf4j
public class PreAuthenticatedAspect {

    @Around("@annotation(preAuthenticated)")
    public Object around(ProceedingJoinPoint joinPoint, PreAuthenticated preAuthenticated) throws Throwable {
        if (SecurityUserUtils.getLoginUser() == null) {
            throw exception(UNAUTHORIZED);
        }
        return joinPoint.proceed();
    }

}
