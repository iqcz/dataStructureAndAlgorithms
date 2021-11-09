package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution153 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (low == high) {
                return nums[low];
            } else if (nums[middle] > nums[high]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return -1;
    }
}