package com.joinky.log.controller;

import com.joinky.log.anotation.LogRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joinky
 * @date 2020-07-29
 * 日志记录controller类
 */
@RestController
@RequestMapping("/log")
@Api(value = "日志管理")
public class LogRecordController {

    @RequestMapping(value = "/record", method = RequestMethod.POST)
    @ApiOperation(value = "记录日志")
    @LogRecord(value = "swagger")
    public String record() {
        return "success";
    }
}
