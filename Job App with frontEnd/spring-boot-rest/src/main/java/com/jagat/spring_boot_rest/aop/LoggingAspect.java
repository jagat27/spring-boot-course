package com.jagat.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.jagat.spring_boot_rest.service.JobService.getJobById(..))")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Method called before " + jp.getSignature().getName());
    }

    @After("execution(* com.jagat.spring_boot_rest.service.JobService.getJobById(..))")
    public void logMethodCalledAfter(JoinPoint jp){
        LOGGER.info("Method called Afterfinal " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.jagat.spring_boot_rest.service.JobService.getJobById(..))")
    public void logMethodCalledAfterReturning(JoinPoint jp){
        LOGGER.info("Method called AfterReturning " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.jagat.spring_boot_rest.service.JobService.getJobById(..))")
    public void logMethodCalledAfterThrowing(JoinPoint jp){
        LOGGER.info("Method called AfterThrowing " + jp.getSignature().getName());
    }

}
