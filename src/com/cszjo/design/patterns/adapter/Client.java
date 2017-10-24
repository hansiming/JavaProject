package com.cszjo.design.patterns.adapter;

/**
 * Created by hansiming on 2017/10/24.
 */
public class Client {

    public static void main(String[] args) {
        DBSocketInterface dbSocketInterface = new Adapter(new GBSocket());
        dbSocketInterface.threeBrand();
    }
}
