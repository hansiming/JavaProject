package com.cszjo.design.patterns.factory.method;

/**
 * Created by hansiming on 2017/10/17.
 */
public class GifImageReader implements ImageReader {

    @Override
    public void read() {
        System.out.println("Gif Image Reading...");
    }
}
