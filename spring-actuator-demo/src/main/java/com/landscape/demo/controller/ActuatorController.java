package com.landscape.demo.controller;

import com.landscape.demo.service.ActuatorService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "/randomCost1", method = RequestMethod.GET)
    public String randomCost1() {
        return actuatorService.randomCost();
    }

    @RequestMapping(value = "/randomCost2", method = RequestMethod.GET)
    public String randomCost2() {
        return actuatorService.randomCost();
    }

}
