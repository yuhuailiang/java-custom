package com.joinky.test;

import com.joinky.proxy.handler.TeacherMethodInterceptor;
import com.joinky.proxy.object.Teacher;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author Joinky
 * @date 2020-07-31
 * cglib动态代理类
 */
public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Teacher.class);
        enhancer.setCallback(new TeacherMethodInterceptor());
        Teacher teacher = (Teacher) enhancer.create();
        teacher.work();
    }
}
