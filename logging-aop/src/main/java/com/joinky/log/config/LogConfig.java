package com.joinky.log.config;

import com.joinky.log.server.AnotationServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joinky
 * @date 2020-07-29
 */

@Configuration
@ComponentScan(basePackages = "com.joinky.log")
public class LogConfig {

    @Bean
    public AnotationServer anotationServer() {
        return new AnotationServer();
    }
}
