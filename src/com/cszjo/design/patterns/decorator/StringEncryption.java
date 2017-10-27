package com.cszjo.design.patterns.decorator;

/**
 * Created by hansiming on 2017/10/27.
 */
public class StringEncryption extends AbstractEncryption {

    public StringEncryption(Readable readable) {
        super(readable);
    }

    @Override
    public void read() {
        System.out.println("字符串加密！！");
        this.readable.read();
    }
}
