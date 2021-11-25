package com.lee.datastructureandalgorithms.leetcode;

/**
 * 找到两个单链表相交的起始节点
 *
 * @author D49450
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != pointB) {
            pointA = pointA == null ? headB : pointA.getNext();
            pointB = pointB == null ? headA : pointB.getNext();
        }
        return pointA;
    }
}
