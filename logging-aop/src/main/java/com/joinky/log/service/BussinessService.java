package com.joinky.log.service;

import com.joinky.log.domain.OperationLogDomain;

/**
 * @author Joinky
 * @date 2020-07-29
 * 业务层接口
 */
public interface BussinessService {

    /**
     * 新增日志记录
     * @param logDomain
     * @return
     */
    int insertLog(OperationLogDomain logDomain);
}
