package com.lee.datastructureandalgorithms.leetcode;

import java.util.PriorityQueue;

/**
 * @author D49450
 */
public class Solution215 {

    // todo 基于快排分区实现

    // todo 基于堆排序实现

    /**
     * 直接利用JDK中的优先队列来实现堆排序，进而实现题目的要求
     * JDK中的优先队列默认是最小堆，最大堆需要自行实现Comparator
     */
    public int findKthLargestWithPQ(int[] nums, int k) {
        /*使用一个含有 k 个元素的最小堆*/
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            /*获取但并不弹出栈顶元素*/
            /*当前遍历的元素比堆顶元素大，当前元素替换栈顶元素*/
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
