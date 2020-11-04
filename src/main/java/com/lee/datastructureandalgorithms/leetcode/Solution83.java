package com.lee.datastructureandalgorithms.leetcode;

/**
 * 删除排序链表中的重复元素
 */
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.getNext() != null) {
            if (cur.getData() == cur.getNext().getData()) {
                cur.setNext(cur.getNext().getNext());
            } else {
                cur = cur.getNext();
            }
        }
        return head;
    }
}