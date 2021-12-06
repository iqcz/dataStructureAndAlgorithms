package com.lee.datastructureandalgorithms.offer;

import com.lee.datastructureandalgorithms.leetcode.ListNode;

/**
 * @author D49450
 */
public class Question21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.setNext(head);

        ListNode front = head;
        ListNode back = sentinel;
        for (int i = 0; i < n; i++) {
            front = front.getNext();
        }

        while (front != null) {
            front = front.getNext();
            back = back.getNext();
        }
        back.setNext(back.getNext().getNext());
        return sentinel.getNext();
    }
}
