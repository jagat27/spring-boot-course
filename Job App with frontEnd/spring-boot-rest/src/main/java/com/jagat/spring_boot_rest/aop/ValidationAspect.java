package com.jagat.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.jagat.spring_boot_rest.service.JobService.getJobById(..)) &&args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp,int postId) throws Throwable {
        if(postId<0){
            LOGGER.info("postId is negative");
            postId = -postId;

            LOGGER.info("Modified to " + postId);
        }

        Object obj = pjp.proceed(new Object[]{postId});
        return obj;
    }
}
