package com.cszjo.design.patterns.bridge;

/**
 * Created by hansiming on 2017/10/25.
 */
public class AbstractConversion implements Convertible {

    protected Connection connection;

    public AbstractConversion(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void convert() {

    }
}
