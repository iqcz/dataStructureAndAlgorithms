package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
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

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.getNext();
        while (slow != fast) {
            if (fast == null || fast.getNext() == null) {
                return false;
            }

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return true;
    }
}