package com.lee.datastructureandalgorithms.leetcode;

/**
 * 两两交换链表中的节点
 * @author D49450
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode current = sentinel;
        while (current.next != null && current.next.next != null) {
            ListNode node1 = current.next;
            ListNode node2 = current.next.next;

            current.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 指针后移
            current = node1;
        }
        return sentinel.next;
    }
}
