package com.cszjo.design.patterns.adapter;

/**
 * Created by hansiming on 2017/10/24.
 */
public class GBSocket implements GBSocketInterface {

    @Override
    public void twoBrand() {
        System.out.println("国标二插座");
    }
}
