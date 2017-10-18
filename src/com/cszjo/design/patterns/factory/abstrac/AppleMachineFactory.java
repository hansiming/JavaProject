package com.cszjo.design.patterns.factory.abstrac;

/**
 * Created by hansiming on 2017/10/18.
 */
public class AppleMachineFactory implements MachineFactory {

    @Override
    public Phone.IPhone createPhone() {
        return new ApplePhone();
    }
}
