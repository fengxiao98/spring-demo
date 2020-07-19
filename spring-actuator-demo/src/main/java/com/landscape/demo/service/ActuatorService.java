package com.landscape.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author fengxiao
 * @date 2020-07-18
 */
@Service
public class ActuatorService {
    private final Logger logger = LoggerFactory.getLogger(ActuatorService.class);
    private final Random random = new Random();

    /**
     * 业务方法，随机睡眠一段时间模拟耗时
     */
    public String business() {
        int l = random.nextInt(500);
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Business接口被访问，响应时间： " + l);
        return "success";
    }
}
