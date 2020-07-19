package com.landscape.demo.advice;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author fengxiao
 * @date 2020-07-18
 */
@Aspect
@Component
public class ActuatorAdvice {
    private final Logger logger = LoggerFactory.getLogger(ActuatorAdvice.class);
    private final Gauge gauge = Gauge.builder("business.cost", this::getLastCost)
            .register(Metrics.globalRegistry);
    private long lastCost = 0L;

    @Around("execution(* com.landscape.demo.controller.ActuatorController.doBusiness(..))")
    public Object cost(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        try {
            Object proceed = joinPoint.proceed();
            lastCost = System.currentTimeMillis() - start;
            return proceed;
        } catch (Throwable e) {
            logger.warn("方法执行失败,Cause: ", e);
            throw new RuntimeException(e);
        }
    }

    public long getLastCost() {
        return lastCost;
    }
}
