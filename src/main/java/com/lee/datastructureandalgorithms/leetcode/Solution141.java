package com.lee.datastructureandalgorithms.leetcode;

/**
 * 环形链表
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

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}