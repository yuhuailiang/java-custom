package com.joinky.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 * @author yuhl
 * @date 2020-07-29
 */
@SpringBootApplication
@Slf4j
@EnableSwagger2
public class LoggingApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(LoggingApplication.class, args);
        } catch (Exception e) {
            log.error("Application start failed: {}", e.getMessage());
        }
    }
}
