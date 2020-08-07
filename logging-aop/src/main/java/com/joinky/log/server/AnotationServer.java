package com.joinky.log.server;

import com.joinky.log.anotation.LogRecord;

/**
 * @author Joinky
 * @date 2020-07-29
 */
public class AnotationServer {

    @LogRecord(value = "测试日志注解是否生效")
    public void record() {
        System.out.println("record log exec");
    }
}
