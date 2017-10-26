package com.cszjo.design.patterns.composite;

/**
 * Created by hansiming on 2017/10/26.
 */
public abstract class Commpont {

    public void remove(Commpont commpont) {
        throw new RuntimeException("not support this method!");
    }

    public void add(Commpont commpont) {
        throw new RuntimeException("not support this method!");
    }

    public abstract void operation();
}
