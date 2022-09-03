package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author i324779
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode current = sentinel;
        // 将 current 移动 left - 1 步
        // current 的 next 就是反转的开始
        for (int i = 0; i < left - 1; i++) {
            current = current.next;
        }
        //要反转的链表结点就是 current 的下一个结点
        ListNode startNode = current.next;
        // 同时记录要反转的下一个结点
        ListNode nextNode = startNode.next;

        for (int i = 0; i < right - left; i++) {
            startNode.next = nextNode.next;
            nextNode.next = current.next;
            current.next = nextNode;
            nextNode = startNode.next;
        }
        return sentinel.next;
    }
}
