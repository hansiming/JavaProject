package com.cszjo.leetcode.link;

public class Solution141 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode low = head;
        ListNode high = head.next;
        while (high != null && high.next != null) {
            if (low == high) {
                return true;
            }

            low = low.next;
            high = high.next.next;
        }

        return false;
    }
}
