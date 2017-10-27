package com.cszjo.design.patterns.decorator;

/**
 * Created by hansiming on 2017/10/27.
 */
public class CsvFile implements Readable {

    @Override
    public void read() {
        System.out.println("read CSV file!!");
    }
}
