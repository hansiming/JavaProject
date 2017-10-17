package com.cszjo.design.patterns.factory.method;

/**
 * Created by hansiming on 2017/10/17.
 */
public class GifImageReaderFactory implements ImageReaderFactory {

    @Override
    public ImageReader getImageReader() {
        return new GifImageReader();
    }
}
