package com.cszjo.leetcode.link;

public class Solution143 {

    ListNode start;

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        start = head;
        recursion(head.next);
    }

    private boolean recursion(ListNode end) {
        if (start == end || end.next == null) {
            return true;
        }

        boolean recursion = recursion(end.next);
        if (!recursion) {
            return recursion;
        }

        if (start.next == null || start.next.next == null) {
            return false;
        }

        ListNode next = start.next;
        start.next = end.next;
        end.next = null;
        start.next.next = next;
        start = next;
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        new Solution143().reorderList(node1);
        System.out.println(node1);
    }
}
