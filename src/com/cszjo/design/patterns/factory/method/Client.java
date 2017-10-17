package com.cszjo.design.patterns.factory.method;

/**
 * Created by hansiming on 2017/10/17.
 */
public class Client {

    public static void main(String[] args) {
        // 这个地方的GifImageReaderFactory可以通过配置文件指定
        ImageReaderFactory factory = new GifImageReaderFactory();
        ImageReader reader = factory.getImageReader();
        reader.read();
    }
}
