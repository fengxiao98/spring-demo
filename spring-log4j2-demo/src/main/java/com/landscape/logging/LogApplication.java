package com.landscape.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author fengxiao
 * @date 2020-07-19
 */
@SpringBootApplication
public class LogApplication {
    private static final Logger logger = LoggerFactory.getLogger(LogApplication.class);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(LogApplication.class, args);
        doLogging();
    }

    public static void doLogging() throws InterruptedException {
        while (true) {
            logger.trace("Timestamp: " + System.currentTimeMillis());
            logger.debug("Timestamp: " + System.currentTimeMillis());
            logger.info("Timestamp: " + System.currentTimeMillis());
            logger.warn("Timestamp: " + System.currentTimeMillis());
            logger.error("Timestamp: " + System.currentTimeMillis());
            Thread.sleep(500);
        }
    }
}
