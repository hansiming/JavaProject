package com.cszjo.design.patterns.bridge;

/**
 * Created by hansiming on 2017/10/25.
 */
public class MysqlConnection implements Connection {

    @Override
    public String getData() {
        return "Mysql Data";
    }
}
