package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.setNext(head);
        ListNode current = sentinel;
        while (current.getNext() != null && current.getNext().getNext() != null) {
            ListNode node1 = current.getNext();
            ListNode node2 = current.getNext().getNext();
            current.setNext(node2);
            node1.setNext(node2.getNext());
            node2.setNext(node1);
            current = node1;
        }
        return sentinel.getNext();
    }
}
