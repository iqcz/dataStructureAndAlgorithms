package com.lee.datastructureandalgorithms.offer;

/**
 * @author D49450
 */
public class Question68 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                if (middle == 0 || nums[middle - 1] < target) {
                    return middle;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return nums.length;
    }
}
