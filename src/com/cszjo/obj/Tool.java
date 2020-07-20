package com.cszjo.obj;

public class Tool {

    private Worker worker;

    public Tool(Worker worker1) {
        worker = worker1;
    }

    public void work() {
        worker.execute();
    }

    public Worker getWorker() {
        return worker;
    }

    public static void main(String[] args) {
        Tool tool = new Tool(new ChildB());
        tool.work();
        Worker worker = tool.getWorker();

        if (worker instanceof ChildA) {

            ChildA worker1 = (ChildA) worker;
            worker1.A();
        }

        System.out.println(worker.getClass());
    }
}
