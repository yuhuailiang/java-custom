package com.joinky.test;

import com.joinky.log.server.AnotationServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Joinky
 * @date 2020-07-29
 * AOP日志测试类
 */
public class LogTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnotationServer.class);
        AnotationServer anotationServer = context.getBean(AnotationServer.class);
        anotationServer.record();
    }
}
