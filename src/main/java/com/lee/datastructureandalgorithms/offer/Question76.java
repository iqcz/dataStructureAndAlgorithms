package com.lee.datastructureandalgorithms.offer;

import static com.lee.datastructureandalgorithms.sort.QuickSort.partition;

/**
 * @author D49450
 */
public class Question76 {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != target) {
            if (index > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

}