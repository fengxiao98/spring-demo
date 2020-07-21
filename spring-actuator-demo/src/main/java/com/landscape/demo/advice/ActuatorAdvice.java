package com.landscape.demo.advice;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import io.prometheus.client.Counter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author fengxiao
 * @date 2020-07-18
 */
@Aspect
@Component
public class ActuatorAdvice {
    private final Logger logger = LoggerFactory.getLogger(ActuatorAdvice.class);
    private HashMap<String, Long> costMap = new HashMap<>();

    @Around("execution(* com.landscape.demo.service.ActuatorService.*(..))")
    public Object cost(ProceedingJoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        long start = System.currentTimeMillis();
        try {
            Object proceed = joinPoint.proceed();
            costMap.put(name, System.currentTimeMillis() - start);
            return proceed;
        } catch (Throwable e) {
            //ignore
            logger.warn("方法执行失败,Cause: ", e);
            return null;
        }
    }

    public long getLastCost(String name) {
        return costMap.getOrDefault(name, 0L);
    }
}
