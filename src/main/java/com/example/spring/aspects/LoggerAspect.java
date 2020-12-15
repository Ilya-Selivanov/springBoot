package com.example.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggerAspect {

        private static final Logger LOG = Logger.getLogger(LoggerAspect.class.getName());

        @Pointcut("execution(* com.example.spring.service.StudentService.*(..))")
        public void callMethodStudentService(){ }



        @Around("callMethodStudentService()")
        public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();
            Object proceed = joinPoint.proceed();
            long runtime = System.currentTimeMillis() - start;
            String methodName = joinPoint.getSignature().getName();
            LOG.info("Method name: " + methodName + " runtime: " + runtime + "ms");

            return proceed;
        }


}
