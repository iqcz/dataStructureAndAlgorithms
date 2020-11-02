package com.lee.datastructureandalgorithms.leetcode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.getNext() != null) {
            fast = fast.getNext();
            if (fast.getNext() == null) {
                return false;
            }
            fast = fast.getNext();
            slow = slow.getNext();

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}