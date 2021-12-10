package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = calculateLength(head);
        k = k % length;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.getNext();
        }

        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        fast.setNext(head);
        head = slow.getNext();
        slow.setNext(null);

        return head;
    }

    private int calculateLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.getNext();
            length++;
        }
        return length;
    }
}
