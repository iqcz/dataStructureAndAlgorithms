package com.lee.datastructureandalgorithms.madeeasyinjava;

import com.lee.datastructureandalgorithms.leetcode.ListNode;

/**
 * 逐对逆置链表。
 * @author D49450
 */
public class Question0332 {

    public static ListNode reversePairRecursive(ListNode head) {
        if (head == null || head.getNext() == null) {
            return null;
        }

        ListNode tmp = head.getNext();
        head.setNext(tmp.getNext());
        tmp.setNext(head);
        head = tmp;
        head.getNext().setNext(reversePairRecursive(head.getNext().getNext()));

        return  head;
    }


    public static ListNode reversePairIterative(ListNode head) {
        ListNode tmp1 = null;
        ListNode tmp2 = null;

        while (head != null && head.getNext() != null) {
            if (tmp1 != null) {
                tmp1.getNext().setNext(head.getNext());
            }
            tmp1 = head.getNext();
            head.setNext(head.getNext().getNext());
            tmp1.setNext(head);

            if (tmp2 == null) {
                tmp2 = tmp1;
            }

            // 指针后移
            head = head.getNext();
        }
        return tmp2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);

        System.out.println("head = " + head);


//        ListNode reversedHead = reversePairRecursive(head);
        ListNode reversedHead = reversePairRecursive(head);

        System.out.println("reversedHead = " + reversedHead);
    }
}