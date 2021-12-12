package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode next;
        ListNode current = head;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            // 向前移动
            previous = current;
            current = next;
        }
        return previous;
    }
}

