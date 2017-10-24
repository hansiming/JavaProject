package com.cszjo.design.patterns.adapter;

/**
 * Created by hansiming on 2017/10/24.
 */
public class DBSocket implements DBSocketInterface {

    @Override
    public void threeBrand() {
        System.out.println("德标三插座");
    }
}
