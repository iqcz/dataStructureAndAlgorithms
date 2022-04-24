package com.lee.datastructureandalgorithms.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author i324779
 */
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        // 小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.getNext() != null) {
            heap.add(pre.getNext());
        }

        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.setNext(cur);
            pre = cur;
            if (cur.getNext() != null) {
                heap.add(cur.getNext());
            }
        }

        return head;
    }

    static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            //如果返回负数，则小的放在前面；如果返回整数，则大的放在前面；
            return o1.getData() - o2.getData();
        }
    }


    /**
     * 使用分治 + 递归 + 两个链表排序方法，实现多个链表合并。
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }

        ListNode resultNode = new ListNode(0);
        ListNode p = resultNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.getData() < listNode2.getData()) {
                p.setNext(listNode1);
                listNode1 = listNode1.getNext();
            } else {
                p.setNext(listNode2);
                listNode2 = listNode2.getNext();
            }
            p = p.getNext();
            if (listNode1 != null) {
                p.setNext(listNode1);
                if (listNode2 != null) {
                    p.setNext(listNode2);
                }
                return resultNode.getNext();
            }


        }
    }