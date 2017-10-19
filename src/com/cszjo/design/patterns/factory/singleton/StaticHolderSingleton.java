package com.cszjo.design.patterns.factory.singleton;

/**
 * Created by hansiming on 2017/10/19.
 */
public class StaticHolderSingleton {

    private static class SingletonHolder {
        private final static StaticHolderSingleton instance = new StaticHolderSingleton();
    }

    public static StaticHolderSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
