package com.cszjo.lintcode.link;

/**
 * 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。请在在O(1)时间复杂度删除该链表节点。
 * Created by hansiming on 2017/10/25.
 */
public class Easy2 {

    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        if (node.next == null)
            node = null;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
