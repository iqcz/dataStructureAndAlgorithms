package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = length(head) - n + 1;

        ListNode sentinel = new ListNode();
        sentinel.setNext(head);
        ListNode current = sentinel;
        for (int i = 1; i < count; ++i) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());

        return sentinel.getNext();
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.getNext();
            length++;
        }
        return length;
    }
}
