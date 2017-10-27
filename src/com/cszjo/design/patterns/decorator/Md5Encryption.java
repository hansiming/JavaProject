package com.cszjo.design.patterns.decorator;

/**
 * Created by hansiming on 2017/10/27.
 */
public class Md5Encryption extends AbstractEncryption {

    public Md5Encryption(Readable readable) {
        super(readable);
    }

    @Override
    public void read() {
        System.out.println("MD5 加密!!");
        this.readable.read();
    }
}
