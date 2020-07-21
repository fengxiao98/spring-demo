package com.landscape.demo.metrics;

import com.landscape.demo.advice.ActuatorAdvice;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.binder.BaseUnits;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.management.BufferPoolMXBean;
import java.util.Collections;

/**
 * @author fengxiao
 * @date 2020-07-20
 */
@Component
public class BusinessMetricsBinder implements MeterBinder {
    private final Logger logger = LoggerFactory.getLogger(BusinessMetricsBinder.class);

    @Autowired
    private ActuatorAdvice actuatorAdvice;

    @Override
    public void bindTo(MeterRegistry registry) {
        Tags cost = Tags.concat(Collections.emptyList(), "id", "randomCost");
        Gauge.builder("business.cost", () -> actuatorAdvice.getLastCost("randomCost"))
                .tags(cost)
                .description("An estimate of the number of buffers in the pool")
                .baseUnit("second")
                .register(registry);
        Tags fail = Tags.concat(Collections.emptyList(), "id", "maybeFail");
        Gauge.builder("business.cost", () -> actuatorAdvice.getLastCost("maybeFail"))
                .tags(fail)
                .description("An estimate of the number of buffers in the pool")
                .baseUnit("second")
                .register(registry);
    }

}
