package com.joinky.test;

import com.joinky.proxy.PersonService;
import com.joinky.proxy.handler.AnimalInvocationHandler;
import com.joinky.proxy.impl.PersonServiceImpl;

/**
 * @author Joinky
 * @date 2020-07-31
 * 动态代理测试类
 */
public class ProxyTest {

    public static void main(String[] args) {
        PersonServiceImpl personService = new PersonServiceImpl();
        AnimalInvocationHandler handler = new AnimalInvocationHandler();
        PersonService proxy = (PersonService) handler.bindObj(personService);
        proxy.study();
        proxy.work();
    }
}
