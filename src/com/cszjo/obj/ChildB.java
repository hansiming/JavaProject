package com.cszjo.obj;

public class ChildB extends Worker {

    @Override
    void execute() {
        System.out.println("I'm B woring!");
    }

    public void b() {
        this.execute();
        System.out.println("b");
    }
}
