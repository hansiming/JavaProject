package com.cszjo.offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 1.在原链表中插入新的链表。
 * 2.新的节点n1->random指向原节点n0->random
 * Created by hansiming on 2017/10/26.
 */
public class Demo24 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }
        head = pHead;
        while (head != null) {
            RandomListNode pre = head;
            RandomListNode cur = head.next;
            if (pre.random != null) {
                cur.random = pre.random.next;
            }
            head = cur.next;
        }
        head = pHead.next;
        RandomListNode cur = pHead.next;
        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return head;

//                if(pHead==null)
//                    return null;
//                RandomListNode pCur = pHead;
//                //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
//                while(pCur!=null){
//                        RandomListNode node = new RandomListNode(pCur.label);
//                        node.next = pCur.next;
//                        pCur.next = node;
//                        pCur = node.next;
//                    }
//                pCur = pHead;
//                //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
//                while(pCur!=null){
//                        if(pCur.random!=null)
//                            pCur.next.random = pCur.random.next;
//                        pCur = pCur.next.next;
//                    }
//                RandomListNode head = pHead.next;
//                RandomListNode cur = head;
//                pCur = pHead;
//                //拆分链表
//                while(pCur!=null){
//                        pCur.next = pCur.next.next;
//                        if(cur.next!=null)
//                            cur.next = cur.next.next;
//                        cur = cur.next;
//                        pCur = pCur.next;
//                    }
//                return head;  
    }

    public static void main(String[] args) {
        //1,2,3,4,5, 3,5,#,2,#
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;
        node2.random = node5;
        node4.random = node2;
        new Demo24().Clone(node1);
    }
}
