package com.lee.datastructureandalgorithms.offer;

import com.lee.datastructureandalgorithms.leetcode.ListNode;

/**
 * 链表中倒数第k个结点
 *
 * @author D49450
 */
public class Question22 {

    public static ListNode kthNodeFromEnd(ListNode head, int kth) {
        if (kth <= 0 || head == null) {
            return null;
        }
        ListNode sentinel = head;
        ListNode kthNode = null;
        for (int i = 1; i < kth; i++) {
            if (sentinel != null) {
                sentinel = sentinel.next;
            }
        }

        while (sentinel != null) {
            if (kthNode == null) {
                kthNode = head;
            } else {
                kthNode = kthNode.next;
            }
            sentinel = sentinel.next;
        }
        return kthNode;
    }

}
