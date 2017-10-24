package com.cszjo.design.patterns.adapter;

/**
 * Created by hansiming on 2017/10/24.
 */
public class Adapter implements DBSocketInterface {

    private GBSocketInterface gbSocketInterface;

    public Adapter(GBSocketInterface gbSocketInterface) {
        this.gbSocketInterface = gbSocketInterface;
    }

    @Override
    public void threeBrand() {
        gbSocketInterface.twoBrand();
    }
}
