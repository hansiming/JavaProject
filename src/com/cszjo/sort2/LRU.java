package com.cszjo.sort2;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    private int capacity;
    private Map<Integer, Node> nodes = new HashMap<>();
    private Node head;
    private Node tail;

    private static class Node {
        Node pre;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRU(int capacity) {
        this.capacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    private void move2Head(Node node) {
        Node next = node.next;
        Node pre = node.pre;

        node.pre = pre;
        pre.next = next;
        add2Head(node);
    }

    private void add2Head(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;

        node.next = next;
        next.pre = node;
    }

    private Node removeTail() {
        Node deleteNode = tail.pre;
        deleteNode.pre.next = tail;
        tail.pre = deleteNode.pre;
        deleteNode.pre = null;
        deleteNode.next = null;
        return deleteNode;
    }

    public int get(int key) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            move2Head(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.val = value;
            move2Head(node);
            return;
        }

        if (nodes.size() >= capacity) {
            Node node = removeTail();
            nodes.remove(node.key);
        }

        Node newNode = new Node(key, value);
        nodes.put(key, newNode);
        add2Head(newNode);
    }
}
