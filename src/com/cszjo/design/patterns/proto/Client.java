package com.cszjo.design.patterns.proto;

import java.util.ArrayList;

/**
 * Created by hansiming on 2017/10/20.
 */
public class Client {

    public static void main(String[] args) {

        DeepClone4Clone cloneIns = new DeepClone4Clone(1, new ArrayList<>());
        DeepClone4Clone newCloneIns = cloneIns.clone();

        System.out.println(cloneIns == newCloneIns);
        System.out.println(cloneIns.getA() == newCloneIns.getA());

        DeepClone4Serialize serIns = new DeepClone4Serialize(1, new ArrayList<>());
        DeepClone4Serialize newSerIns = new DeepClone4Serialize(1, new ArrayList<>());

        System.out.println(serIns == newSerIns);
        System.out.println(serIns.getA() == newSerIns.getA());
    }
}
