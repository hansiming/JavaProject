package com.cszjo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

import com.cszjo.leetcode.link.Solution148;

public class Solution146 {

    Map<Integer, NodeList> map = new HashMap<>();

    final NodeList head;
    final NodeList tail;
    final int capacity;

    static class NodeList {
        private int key;
        private int val;
        private NodeList pre;
        private NodeList next;

        public NodeList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Solution146(int capacity) {
        head = new NodeList(-1, -1);
        tail = new NodeList(-1, -1);

        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    private void modeNode2Head(int val) {
        NodeList curNode = map.get(val);

        NodeList curPre = curNode.pre;
        curNode.pre.next = curNode.next;
        curNode.next.pre = curPre;

        addNode2Head(curNode);
    }

    private void addNode2Head(NodeList node) {
        NodeList curNext = head.next;
        head.next = node;
        node.pre = head;

        curNext.pre = node;
        node.next = curNext;
    }

    private NodeList removeTail() {
        NodeList curNode = tail.pre;
        NodeList curPre = curNode.pre;
        curPre.next = tail;
        tail.pre = curPre;

        return curNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            modeNode2Head(key);

            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            NodeList node = map.get(key);
            node.val = value;
            modeNode2Head(key);
            return;
        }

        if (map.size() >= capacity) {
            NodeList deleteNode = removeTail();
            map.remove(deleteNode.key);
        }

        NodeList node = new NodeList(key, value);
        addNode2Head(node);
        map.put(key, node);
    }

    public static void main(String[] args) {
        Solution146 solution146 = new Solution146(2);
        solution146.put(1, 1);
        solution146.put(2, 2);

        solution146.get(1);

        solution146.put(3,3);
        int i = solution146.get(2);
        System.out.println(i);
    }
}