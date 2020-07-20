package com.cszjo.leetcode.link;

public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        ListNode low = new ListNode(-1);
        ListNode high = new ListNode(-1);

        ListNode curLow = low;
        ListNode curHigh = high;
        while (head != null) {
            if (head.val >= x) {
                curHigh.next = head;
                curHigh = curHigh.next;
            } else {
                curLow.next = head;
                curLow = curLow.next;
            }
            head = head.next;
        }

        curLow.next = high.next;
        curHigh.next = null;
        return low.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode partition = new Solution86().partition(l1, 4);
    }
}
