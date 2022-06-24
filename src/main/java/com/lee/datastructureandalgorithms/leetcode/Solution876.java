package com.lee.datastructureandalgorithms.leetcode;

/**
 * 快慢指针
 * @author D49450
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        // 注意，返回slow
        return slow;
    }
}
