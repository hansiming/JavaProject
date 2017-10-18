package com.cszjo.design.patterns.factory.abstrac;

/**
 * Created by hansiming on 2017/10/18.
 */
public class Phone {

    interface IPhone {
        void disPlay();
    }
}

class ApplePhone implements Phone.IPhone {

    @Override
    public void disPlay() {
        System.out.println("Get A Apple Phone...");
    }
}

class HuaWeiPhone implements Phone.IPhone {

    @Override
    public void disPlay() {
        System.out.println("Get A HuaWei Phone...");
    }
}
