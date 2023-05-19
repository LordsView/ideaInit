package com.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类 名: InvocationHandlerImpl
 * 描 述: 处理器处理类
 * 作 者: LZZ
 * 创 建： 2020/7/30
 * 版 本：
 * <p>
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object subject;


    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理-方法调用前....");
        System.out.println("Method:" + method);
        Object returnValue = method.invoke(subject, args);
        System.out.println("动态代理-方法调用后....");
        return returnValue;
    }
}
