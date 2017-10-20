package com.cszjo.design.patterns.proto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hansiming on 2017/10/20.
 */
public class DeepClone4Serialize implements Clone<DeepClone4Serialize> {

    private int id = 0;
    private List<Integer> a = new ArrayList<>();

    public DeepClone4Serialize(int id, List<Integer> a) {
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

    @Override
    public DeepClone4Serialize clone() {

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(this);

            ByteArrayInputStream bis = new  ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            return (DeepClone4Serialize) in.readObject();

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        return null;
    }
}
