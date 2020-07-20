package com.cszjo.leetcode.link;

public class Solution876 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
