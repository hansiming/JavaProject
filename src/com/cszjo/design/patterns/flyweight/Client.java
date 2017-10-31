package com.cszjo.design.patterns.flyweight;

/**
 * Created by hansiming on 2017/10/31.
 */
public class Client {

    public static void main(String[] args) {
        WebSite webSite1 = WebSiteFactory.getWebSite("blog");
        webSite1.display("rich");
        WebSite webSite2 = WebSiteFactory.getWebSite("news");
        webSite2.display("rich");
    }
}
