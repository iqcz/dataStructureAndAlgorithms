package com.lee.datastructureandalgorithms.leetcode;

/**
 * 有序数组中的单一元素
 * @author i324779
 */
public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
