package com.cszjo.design.patterns.decorator;

/**
 * Created by hansiming on 2017/10/27.
 */
public abstract class AbstractEncryption implements Readable {

    protected Readable readable;

    public AbstractEncryption(Readable readable) {
        this.readable = readable;
    }
}
