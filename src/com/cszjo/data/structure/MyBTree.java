package com.cszjo.data.structure;

/**
 * Created by hansiming on 2017/10/20.
 */
public class MyBTree <K extends Comparable<K>, V> {

    /**
     * 实现一个5阶的B树
     */
    public final static int M = 5;

    /**
     * B树中节点的个数
     */
    private int size = 0;

    /**
     * B树种的高度
     */
    private int hight = 0;

    private static class Node {
        private int entryCount;
        private Entry[] children = new Entry[M];
    }

    private static class Entry {

    }

    public int getSize() {
        return this.size;
    }

    public int getHight() {
        return this.hight;
    }
}
