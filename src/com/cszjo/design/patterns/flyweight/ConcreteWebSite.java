package com.cszjo.design.patterns.flyweight;

/**
 * Created by hansiming on 2017/10/31.
 */
public class ConcreteWebSite implements WebSite {

    private String name;

    public ConcreteWebSite(String name) {
        this.name = name;
    }

    @Override
    public void display(String userName) {
        System.out.println(userName + " is looking for " + name + "!!");
    }
}
