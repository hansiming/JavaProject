package com.cszjo.design.patterns.bridge;

/**
 * Created by hansiming on 2017/10/25.
 */
public class Client {

    public static void main(String[] args) {
        Connection connection = new MysqlConnection();
        Convertible convert = new TxtConversion(connection);
        convert.convert();
    }
}
