package com.cszjo.design.patterns.bridge;

/**
 * Created by hansiming on 2017/10/25.
 */
public class CsvConversion extends AbstractConversion {

    public CsvConversion(Connection connection) {
        super(connection);
    }

    @Override
    public void convert() {
        System.out.println(this.connection.getData());
        System.out.println("------------to CSV----------------");
    }
}
