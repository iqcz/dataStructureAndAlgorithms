package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author i324779
 */
public class Solution25II {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;

        int i = 0;

        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    /**
     * 反转链表结点
     * 比较简约
     * */
    public ListNode reverse(ListNode preSubList, ListNode subListNext) {
        ListNode start = preSubList.next;
        ListNode next = start.next;
        while (start.next != subListNext) {
            start.next = next.next;
            next.next = preSubList.next;
            preSubList.next = next;
            next = start.next;
        }
        return start;
    }
}
