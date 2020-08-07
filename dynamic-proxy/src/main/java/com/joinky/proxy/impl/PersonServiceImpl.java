package com.joinky.proxy.impl;

import com.joinky.proxy.PersonService;

/**
 * @author Joinky
 * @date 2020-07-31
 * 人类接口实现类
 */
public class PersonServiceImpl implements PersonService {

    /**
     * 人类学习方法
     */
    @Override
    public void study() {
        System.out.println("我是人类学习的实现");
    }

    /**
     * 人类工作方法
     */
    @Override
    public void work() {
        System.out.println("我是人类工作的实现");
    }
}
