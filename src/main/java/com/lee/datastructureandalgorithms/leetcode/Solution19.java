package com.lee.datastructureandalgorithms.leetcode;

/**
 * 删除链表的倒数第 N 个结点
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
     * @param head 链表头结点
     * @param n 倒数第n个数
     * @return 删除后的链表
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        ListNode fast = sentinel;
        ListNode slow = sentinel;
        sentinel.next = head;

        for (int i = 0; i <= n; i++) {
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