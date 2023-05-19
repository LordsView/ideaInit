package com.demo.aop;

/**
 * 类 名: StaticProxyDemo
 * 描 述:
 * 作 者: LZZ
 * 创 建： 2020/7/30
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        SubjectStaticProxy subjectStaticProxy = new SubjectStaticProxy(realSubject);

        String hello = subjectStaticProxy.sayHello("jack");
        System.err.println(hello);
    }
}
