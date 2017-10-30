package com.cszjo.design.patterns.facede;

/**
 * Created by hansiming on 2017/10/30.
 */
public class Facade {

    private Service serviceA;
    private Service serviceB;
    private Service serviceC;

    public Facade() {
        this.serviceA = new ServiceA();
        this.serviceB = new ServiceB();
        this.serviceC = new ServiceC();
    }

    public void serviceA () {
        serviceA.service();
        serviceB.service();
    }

    public void serviceB () {
        serviceB.service();
        serviceC.service();
    }
}
