package com.cszjo.data.structure.tree;

/**
 * Created by hansiming on 2017/10/20.
 */
public class MyBTree <K extends Comparable<K>, V> {

    /**
     * 实现一个5阶的B树
     */
    public final static int M = 5;

    private Node root;

    /**
     * B树中节点的个数
     */
    private int size = 0;

    /**
     * B树种的高度
     */
    private int hight = 0;

    public MyBTree() {
        Node root = new Node(0);
        this.root = root;
    }

    private static class Node {
        private int entryCount;
        private Entry[] children = new Entry[M];

        public Node(int entryCount) {
            this.entryCount = entryCount;
        }
    }

    private static class Entry {
        private Comparable key;
        private Object value;
        private Node next;

        public Entry(Comparable key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getHight() {
        return this.hight;
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("key can`t be null");
        }
        return search(key, root, hight);
    }

    private V search(K key, Node n, int ht) {
        if (ht == 0) {
            for (int i = 0; i < n.entryCount; i++) {
                if (eq(key, n.children[i].key)) {
                    return (V) n.children[i].value;
                }
            }
            return null;
        } else {
            for (int i = 0; i < n.entryCount; i++) {
                if (i + 1 == n.entryCount || less(key, n.children[i].key)) {
                    return search(key, n.children[i].next, --ht);
                }
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("key can`t be null");
        }

        Node u = insert(key, value, root, hight);
        this.size++;
        if (u == null)
            return;

        Node n = new Node(2);
        n.children[0] = new Entry(root.children[0].key, null, root);
        n.children[1] = new Entry(u.children[0].key, null, u);
        this.hight++;
    }

    public Node insert(K key, V value, Node n, int ht) {
        Entry entry = new Entry(key, value, null);
        int index = 0;
        if (ht == 0) {
            for (int i = 0; i < n.entryCount; i++) {
                if (i + 1 == n.entryCount || less(key, n.children[i].key)) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < n.entryCount; i++) {
                if (i + 1 == n.entryCount || less(key, n.children[i].key)) {
                    index = i;
                    Node l = insert(key, value, n.children[i].next, --ht);
                    if (l == null)
                        return null;
                    entry.key = l.children[0].key;
                    entry.next = l;
                }
            }
        }

        for (int i = n.entryCount - 1; i >= index; i--) {
            n.children[i] = n.children[i - 1];
        }
        n.children[index] = entry;
        n.entryCount++;
        if (n.entryCount <= M) {
            return null;
        } else {
            return split(n);
        }
    }

    private Node split(Node o) {
        Node n = new Node(M / 2);
        for (int i = 0; i < M / 2; i++) {
            n.children[i] = o.children[M / 2 + i];
        }
        o.entryCount = M / 2;
        return n;
    }

    private boolean eq(Comparable key1, Comparable key2) {
        return key1.compareTo(key2) == 0;
    }

    private boolean less(Comparable key1, Comparable key2) {
        return key1.compareTo(key2) < 0;
    }
}
