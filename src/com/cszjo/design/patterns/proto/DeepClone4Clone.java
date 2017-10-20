package com.cszjo.design.patterns.proto;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式：深复制
 * Created by hansiming on 2017/10/20.
 */
public class DeepClone4Clone implements Clone<DeepClone4Clone> {

    private int id = 0;
    private List<Integer> a = new ArrayList<>();

    public DeepClone4Clone(int id, List<Integer> a) {
        this.id = id;
        this.a = a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getA() {
        return a;
    }

    public void setA(List<Integer> a) {
        this.a = a;
    }

    public DeepClone4Clone clone() {
        DeepClone4Clone newInstance = null;
        try {
            newInstance = (DeepClone4Clone) super.clone();
            List<Integer> newA = new ArrayList<>();
            newA.addAll(this.a);
            newInstance.setA(newA);
        } catch (CloneNotSupportedException e) {

        }
        return newInstance;
    }
}
