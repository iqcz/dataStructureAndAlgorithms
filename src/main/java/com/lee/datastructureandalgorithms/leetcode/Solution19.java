package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = length(head) - n + 1;

        ListNode sentinel = new ListNode();
        sentinel.setNext(head);
        ListNode current = sentinel;
        for (int i = 1; i < count; ++i) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());

        return sentinel.getNext();
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.getNext();
            length++;
        }
        return length;
    }

    /**
     * 使用快慢指针
     * 哨兵节点，解决 null 等情况
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        ListNode fast = sentinel;
        ListNode slow = sentinel;
        sentinel.next = head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return sentinel.next;
    }
}
