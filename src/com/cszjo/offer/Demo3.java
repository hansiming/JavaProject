package com.cszjo.offer;

import java.util.ArrayList;

/**
 * Created by hansiming on 2017/9/14.
 */
public class Demo3 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ArrayList<Integer> array = new ArrayList<>();

    /**
     * 输入一个链表，从尾到头打印链表每个节点的值 (递归)
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        recursive(listNode);
        return array;
    }

    public static void recursive(ListNode listNode) {
        if (listNode == null) {
            return;
        }

        recursive(listNode.next);
        array.add(listNode.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(printListFromTailToHead(l1));

    }
}
