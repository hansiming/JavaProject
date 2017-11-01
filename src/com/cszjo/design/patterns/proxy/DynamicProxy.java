package com.cszjo.design.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hansiming on 2017/11/1.
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------------------proxy before----------------");
        method.invoke(object, args);
        System.out.println("----------------------proxy after-----------------");
        return null;
    }
}
