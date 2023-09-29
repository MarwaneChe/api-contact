package com.mch.contactmanagement.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@Slf4j
public class LoggingAspectContact {

    @Pointcut("execution(* com.mch.contactmanagement.*.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void logBeforeCallMethodeService(JoinPoint joinPoint){
        log.info("Method called : {} - With argument : {} - Kind : {}",joinPoint,joinPoint.getArgs(),joinPoint.getKind());
    }

    @AfterReturning(pointcut = "pointcut()",returning = "result")
    public void logAfterSuccessCallMethod(JoinPoint joinPoint, Object result){
        log.info("End Method Success called {} - result returned : {}",joinPoint,result);
    }

    @AfterThrowing(pointcut = "pointcut()",throwing = "exception")
    public void logAfterErrorCallMethode(JoinPoint joinPoint, Exception exception){
        log.error("End Method Error called : {} - exception : {}",joinPoint,exception);
    }


}
