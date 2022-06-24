package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        boolean existsCycle = false;
        // 找到环
        while (fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
            if (slowPointer == fastPointer) {
                existsCycle =  true;
                break;
            }
        }

        // 存在环
        if (existsCycle) {
            // 慢指针重新指向表头
            slowPointer = head;
            while (slowPointer != fastPointer) {
                slowPointer = slowPointer.getNext();
                fastPointer = fastPointer.getNext();
            }
            return slowPointer;
        }
       return null;
    }
}