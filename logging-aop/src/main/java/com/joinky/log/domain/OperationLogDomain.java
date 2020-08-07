package com.joinky.log.domain;

import lombok.Data;

/**
 * @author Joinky
 * @date 2020-07-29
 * 操作日志实体类
 */
@Data
public class OperationLogDomain {

    /**
     * 日志id
     */
    private Long id;
    /**
     * 操作内容
     */
    private String operation;
    /**
     * 操作日期和时间
     */
    private String date;
    /**
     * 操作结果 0-成功 1-失败
     */
    private int result;
    /**
     * 操作异常记录
     */
    private String exception;
}
