package com.demo.aop;

import java.lang.reflect.Proxy;

/**
 * 类 名: DynamicProxyDemo
 * 描 述:
 * 作 者: LZZ
 * 创 建： 2020/7/30
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        InvocationHandlerImpl handler = new InvocationHandlerImpl(realSubject);

        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();

        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, interfaces, handler);


        System.out.println("动态代理对象的类型"+subject.getClass().getName());

        String hello = subject.sayHello("jack");

        System.err.println(hello);
//        subject.sayGoodBye();
    }
}
