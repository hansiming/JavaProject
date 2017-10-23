package com.cszjo.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * Created by hansiming on 2017/10/23.
 */
public class Demo14 {

    public ListNode FindKthToTail(ListNode head,int k) {

        if (k == 0)
            return null;

        ListNode fast = head, slow =  null;
        int n = 0;
        while (fast != null) {
            if (n == k - 1) {
                slow = head;
            } else if (n >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            n++;
        }
        return slow;
    }
}
