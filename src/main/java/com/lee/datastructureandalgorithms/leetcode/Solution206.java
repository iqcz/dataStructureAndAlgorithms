package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author osyuj
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode next;
        ListNode current = head;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }
}

