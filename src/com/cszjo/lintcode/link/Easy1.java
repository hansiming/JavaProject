package com.cszjo.lintcode.link;

/**
 * 给一个链表，两两交换其中的节点，然后返回交换后的链表。
 * Created by hansiming on 2017/10/25.
 */
public class Easy1 {

    public ListNode swapPairs(ListNode head) {

        if (head == null)
            return null;

        ListNode pre = head, cur = head;
        while ((cur = pre.next) != null) {
            int tmp = pre.val;
            pre.val = cur.val;
            cur.val = tmp;
            pre = cur.next;
            if (pre == null)
                break;
        }
        return head;
    }
}
