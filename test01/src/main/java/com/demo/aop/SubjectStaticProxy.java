package com.demo.aop;

/**
 * 类 名: SubjectStaticProxy
 * 描 述:
 * 作 者: LZZ
 * 创 建： 2020/7/30
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class SubjectStaticProxy implements Subject {

    private Subject subject;

    public SubjectStaticProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("静态代理-方法执行前...");
        String hello = subject.sayHello(name);
        System.out.println("静态代理-方法执行后...");
        return hello;
    }

    @Override
    public String sayGoodBye() {
        return subject.sayGoodBye();
    }
}
