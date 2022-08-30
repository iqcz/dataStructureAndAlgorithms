package com.lee.datastructureandalgorithms.leetcode;

/**
 * 最长连续递增序列
 * @author i324779
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int maxContinuousCount = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                k = i;
            }
            maxContinuousCount = Math.max(maxContinuousCount, i - k + 1);
        }
        return maxContinuousCount;
    }
}
