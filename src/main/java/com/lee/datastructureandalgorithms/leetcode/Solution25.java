package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 哨兵
        ListNode sentinel = new ListNode(0);
        sentinel.setNext(head);

        ListNode pre = sentinel;
        ListNode end = sentinel;

        while (end.getNext() != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.getNext();
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.getNext();
            ListNode next = end.getNext();
            end.setNext(null);
            pre.setNext(reverse(start));
            start.setNext(next);
            pre = start;
            end = pre;
        }
        return sentinel.getNext();
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
