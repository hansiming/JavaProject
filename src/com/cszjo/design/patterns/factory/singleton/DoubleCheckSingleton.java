package com.cszjo.design.patterns.factory.singleton;

/**
 * Created by hansiming on 2017/10/19.
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton() {
        // prevent instance on outer
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
