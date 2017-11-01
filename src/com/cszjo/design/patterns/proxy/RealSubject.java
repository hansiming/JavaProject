package com.cszjo.design.patterns.proxy;

/**
 * Created by hansiming on 2017/11/1.
 */
public class RealSubject implements Subject {

    @Override
    public void sayHello() {
        System.out.println("Say Hello!!!");
    }
}
