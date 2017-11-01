package com.cszjo.design.patterns.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by hansiming on 2017/11/1.
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Subject.class}, new DynamicProxy(new RealSubject()));
        subject.sayHello();
    }
}
