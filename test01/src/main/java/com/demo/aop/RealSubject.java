package com.demo.aop;

/**
 * 类 名: RealSubject
 * 描 述:
 * 作 者: LZZ
 * 创 建： 2020/7/30
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class RealSubject implements Subject {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String sayGoodBye() {
        return "say goodbye";
    }
}
