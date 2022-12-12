package com.myservice.aop;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
  private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);

  @Around("execution(* com.myservice.component..*Scheduler.*(..))"
      +" or execution(* com.myservice.component..NaverSearchApi.*(..))"
      +" or execution(* com.myservice.service..*Service.*(..))")
  public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


    String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();

    log.info(type+"."+proceedingJoinPoint.getSignature().getName()+"() <=================");
    log.info("Argument/Parameter : "+ Arrays.toString(proceedingJoinPoint.getArgs()));
    log.info("=================>");

    return proceedingJoinPoint.proceed();
  }

}
