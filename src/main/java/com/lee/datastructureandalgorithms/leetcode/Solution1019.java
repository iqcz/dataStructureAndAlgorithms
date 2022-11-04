package com.lee.datastructureandalgorithms.leetcode;


import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 链表中的下一个更大节点
 * @author i324779
 */
public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode current = head;

        Map<Integer, Integer> map = Maps.newHashMap();
        // todo
        return null;
    }
}
