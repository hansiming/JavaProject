package com.cszjo.design.patterns.factory.abstrac;

/**
 * Created by hansiming on 2017/10/18.
 */
public class HuaWeiMachineFactory implements MachineFactory {

    @Override
    public Phone.IPhone createPhone() {
        return new HuaWeiPhone();
    }
}
