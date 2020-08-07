package com.joinky.log.service.impl;

import com.joinky.log.domain.OperationLogDomain;
import com.joinky.log.service.BussinessService;
import org.springframework.stereotype.Service;

/**
 * @author Joinky
 * @date
 * 实现类
 */
@Service("bussinessService")
public class BussinessServiceImpl implements BussinessService {

    @Override
    public int insertLog(OperationLogDomain logDomain) {
        System.out.println(logDomain);
        System.out.println("日志记录成功");
        return 1;
    }
}
