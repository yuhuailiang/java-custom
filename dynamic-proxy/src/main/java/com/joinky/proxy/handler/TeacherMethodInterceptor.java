package com.joinky.proxy.handler;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TeacherMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("老师被代理前");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("老师被代理后");
        return object;
    }
}
