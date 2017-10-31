package com.cszjo.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hansiming on 2017/10/31.
 */
public class WebSiteFactory {

    private static Map<String, WebSite> flyWeightFactory = new HashMap<>();

    public static WebSite getWebSite(String name) {
        if (!flyWeightFactory.containsKey(name)) {
            flyWeightFactory.put(name, new ConcreteWebSite(name));
        }
        return flyWeightFactory.get(name);
    }
}
