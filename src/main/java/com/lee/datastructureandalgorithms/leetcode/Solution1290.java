package com.lee.datastructureandalgorithms.leetcode;

/**
 * 二进制链表转整数
 * @author D49450
 */
public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans = ans * 2 + cur.getData();
            cur = cur.getNext();
        }
        return ans;
    }
}
