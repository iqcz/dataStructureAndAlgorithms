package com.lee.datastructureandalgorithms.leetcode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author i324779
 */
public class Solution21 {

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.getData() < l2.getData()) {
            l1.setNext(mergeTwoLists(l1.getNext(), l2));
            return l1;
        } else {
            l2.setNext(mergeTwoLists(l1, l2.getNext()));
            return l2;
        }
    }

    /**
     * 引入哨兵
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode mergedList = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.getData() <= l2.getData()) {
                mergedList.setNext(l1);
                l1 = l1.getNext();
            } else {
                mergedList.setNext(l2);
                l2 = l2.getNext();
            }
            mergedList = mergedList.getNext();
        }

        // 注意此步骤
        mergedList.setNext(l1 == null ? l2 : l1);

        return sentinel.getNext();
    }
}
