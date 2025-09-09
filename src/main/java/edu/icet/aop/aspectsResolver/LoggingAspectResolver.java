package edu.icet.aop.aspectsResolver;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LoggingAspectResolver {

    @Around("@annotation(edu.icet.demoervice.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //my logic before execute joinPoint method
        long start = System.currentTimeMillis();

        // Then execute the joinPoint method
        Object proceed = joinPoint.proceed();

        //my logic after execute joinPoint method
        long executionTime = System.currentTimeMillis() - start;

        // Log the execution time
        log.info("Method {} executed in {} ms", joinPoint.getSignature(), executionTime);

        return proceed; // or return a value if needed
    }
}
