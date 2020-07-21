package com.landscape.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置feign的日志级别，feign提供了四种日志级别，可以自己看一下源码
 *
 * @author fengxiao
 * @date 2020-07-21
 */
@Configuration
public class FeignLogConfiguration {

    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.BASIC;
    }
}
