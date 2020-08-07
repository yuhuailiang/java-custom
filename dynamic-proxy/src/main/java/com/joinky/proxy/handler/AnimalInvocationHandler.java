package com.joinky.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Joinky
 * @date 2020-07-31
 * 动态代理类
 */
public class AnimalInvocationHandler implements InvocationHandler {

    private Object object;

    public Object bindObj(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this::invoke);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("代理前");
        result = method.invoke(object, args);
        System.out.println("代理后");
        return result;
    }
}
