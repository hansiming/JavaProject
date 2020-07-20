package com.cszjo.leetcode.link;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int plus = 0;
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        while (l1 != null || l2 != null) {
            int cur = plus;
            plus = 0;
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }

            if (cur >= 10) {
                plus = 1;
                cur -= 10;
            }

            curNode.next = new ListNode(cur);
            curNode = curNode.next;
        }

        if (plus > 0) {
            curNode.next = new ListNode(plus);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(9);
        ListNode listNode = new Solution2().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
