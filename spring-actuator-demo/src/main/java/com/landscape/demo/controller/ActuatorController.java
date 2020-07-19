package com.landscape.demo.controller;

import com.landscape.demo.service.ActuatorService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengxiao
 * @date 2020-07-18
 */
@RestController
public class ActuatorController {

    @Autowired
    private ActuatorService actuatorService;

    @Timed(value = "business.time")
    @RequestMapping(value = "/business", method = RequestMethod.GET)
    public String doBusiness() {
        return actuatorService.business();
    }

}
