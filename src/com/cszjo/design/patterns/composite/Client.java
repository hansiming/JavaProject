package com.cszjo.design.patterns.composite;

/**
 * Created by hansiming on 2017/10/26.
 */
public class Client {

    public static void main(String[] args) {
        Commpont window = new WindowContainer();
        window.add(new Button());
        window.add(new CheckBox());
        window.operation();
    }
}
