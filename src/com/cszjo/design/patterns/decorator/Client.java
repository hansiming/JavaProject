package com.cszjo.design.patterns.decorator;

/**
 * Created by hansiming on 2017/10/27.
 */
public class Client {

    public static void main(String[] args) {
        Readable txtFile = new TextFile();
        Md5Encryption encryption = new Md5Encryption(txtFile);
        StringEncryption stringEncryption = new StringEncryption(encryption);
        stringEncryption.read();
    }
}
