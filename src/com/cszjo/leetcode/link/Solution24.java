package com.cszjo.leetcode.link;

public class Solution24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        head = cur;

        ListNode next = null;
        while (pre != null && pre.next != null) {
            cur = pre.next;
            next = cur.next;
            if (next == null) {
                pre.next = null;
            } else if (next.next != null) {
                pre.next = next.next;
            } else {
                pre.next = next;
            }
            cur.next = pre;
            pre = next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode listNode = new Solution24().swapPairs(l1);
        System.out.println(listNode);
    }
}
