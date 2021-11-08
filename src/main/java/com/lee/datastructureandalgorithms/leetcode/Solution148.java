package com.lee.datastructureandalgorithms.leetcode;

/**
 * 思路：使用快慢指针，找到链表的中点位置，然后归并排序
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode start, ListNode end) {
        if (start == end) {
            return start;
        }

        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.getNext() != end) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        ListNode l2 = sort(slow.getNext(), end);
        slow.setNext(null);
        ListNode l1 = sort(start, slow);


        return merge(l1, l2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        if (node1.getData() < node2.getData()) {
            node1.setNext(merge(node1.getNext(), node2));
            return node1;
        } else {
            node2.setNext(merge(node1, node2.getNext()));
            return node2;
        }
    }
}