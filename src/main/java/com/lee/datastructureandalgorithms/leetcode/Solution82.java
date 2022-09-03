package com.lee.datastructureandalgorithms.leetcode;

/**
 * 删除排序链表中的重复元素 II
 * @author i324779
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0);
        ListNode current = sentinel;
        sentinel.next = head;

        while (current.next != null && current.next.next != null) {
            if (current.next.getData() == current.next.next.getData()) {
                int x = current.next.getData();
                while (current.next != null && current.next.getData() == x) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return sentinel.next;
    }
}
