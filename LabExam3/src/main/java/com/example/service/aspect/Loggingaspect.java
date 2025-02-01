package com.example.service.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class Loggingaspect {
    private static final Logger logger = LoggerFactory.getLogger(Loggingaspect.class);

    @Pointcut("@annotation(com.example.service.BankService)")
    public void businessMethods() {}

    @Before("businessMethods()")
    public void logBefore() {
        logger.info("Business method execution started.");
    }

    @After("businessMethods()")
    public void logAfter() {
        logger.info("Business method execution completed.");
    }
}
