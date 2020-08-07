package com.joinky.log.aop;

import com.joinky.log.anotation.LogRecord;
import com.joinky.log.domain.OperationLogDomain;
import com.joinky.log.service.BussinessService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Joinky
 * @date 2020-07-29
 */
@Component
@Aspect
public class LogAspect {

    @Autowired
    private BussinessService bussinessService;

    @Pointcut(value = "@annotation(com.joinky.log.anotation.LogRecord)")
    public void logRecord() {}

    @Around(value = "logRecord()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String time = formatter.format(localDateTime);
        Object proceed = point.proceed();
        System.out.println("around exec");
        saveLog(point, time);
    }

    /**
     * 保存日志
     * @param point
     * @param time
     * @throws Throwable
     */
    private void saveLog(ProceedingJoinPoint point, String time) throws Throwable {
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        LogRecord logRecord = method.getAnnotation(LogRecord.class);
        String operation = logRecord.value();
        OperationLogDomain logDomain = new OperationLogDomain();
        logDomain.setDate(time);
        logDomain.setId(1L);
        logDomain.setOperation(operation);
        logDomain.setResult(1);

        // 执行保存
        bussinessService.insertLog(logDomain);
    }

    @Before(value = "logRecord()")
    public void before(JoinPoint point) throws Throwable {
        System.out.println("before exec");
    }

    @After(value = "logRecord()")
    public void after(JoinPoint point) throws Throwable {
        System.out.println("after exec");
    }

    @AfterReturning(value = "logRecord()")
    public void afterReturn(JoinPoint point) throws Throwable {
        System.out.println("after returning exec");
    }

    @AfterThrowing(value = "logRecord()")
    public void afterThrow(JoinPoint point) {
        System.out.println("after throw exec");
    }
}
