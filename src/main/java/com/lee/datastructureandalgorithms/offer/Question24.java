package com.lee.datastructureandalgorithms.offer;

import com.lee.datastructureandalgorithms.leetcode.ListNode;

/**
 * 反转链表
 * @author D49450
 */
public class Question24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        return previous;
    }
}
