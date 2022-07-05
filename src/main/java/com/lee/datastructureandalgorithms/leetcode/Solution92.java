package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author i324779
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        // 将 preNode 移动 left - 1 步
        // preNode 的 next 就是反转的开始
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }
        //要反转的链表结点就是 preNode 的下一个结点
        ListNode startNode = preNode.next;
        // 同时记录要反转的下一个结点
        ListNode nextNode = startNode.next;

        for (int i = 0; i < right - left; i++) {
            startNode.next = nextNode.next;
            nextNode.next = preNode.next;
            preNode.next = nextNode;
            nextNode = startNode.next;
        }
        return dummy.next;
    }
}
