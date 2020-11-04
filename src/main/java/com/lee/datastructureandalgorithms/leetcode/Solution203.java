package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author osyuj
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        // 使用哨兵，只在head的前面
        ListNode sentinel = new ListNode();
        ListNode previous = sentinel;
        ListNode current = head;
        while (current != null) {
            if (current.getData() == val) {
                previous.setNext(current.getNext());
            } else {
                previous = current;
            }

            current = current.getNext();
        }

        return sentinel.getNext();
    }
}
