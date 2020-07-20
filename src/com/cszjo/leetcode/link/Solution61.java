package com.cszjo.leetcode.link;

public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }

        int offset = k % cnt;

        if (offset == 0) {
            return head;
        }

        cur = head;
        ListNode fast = head;
        while (offset-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            cur = cur.next;
        }

        ListNode res = cur.next;
        cur.next = null;
        fast.next = head;
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        new Solution61().rotateRight(l1, 5);
    }
}
