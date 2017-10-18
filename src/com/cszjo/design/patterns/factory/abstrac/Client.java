package com.cszjo.design.patterns.factory.abstrac;

/**
 * Created by hansiming on 2017/10/18.
 */
public class Client {

    public static void main(String[] args) {
        MachineFactory factory = new AppleMachineFactory();
        Phone.IPhone phone = factory.createPhone();
        phone.disPlay();
    }
}
