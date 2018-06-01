package com.example.mybatis.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/6/1.
 * @description
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target, Class[] interfaces) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("我准备说Hello,");
        result = method.invoke(target, args);
        System.out.println("我说过了Hello.");
        return result;
    }
}
