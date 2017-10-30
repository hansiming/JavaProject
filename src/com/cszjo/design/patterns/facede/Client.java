package com.cszjo.design.patterns.facede;

/**
 * Created by hansiming on 2017/10/30.
 */
public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.serviceA();
        facade.serviceB();
    }
}
