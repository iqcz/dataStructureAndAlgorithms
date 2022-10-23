package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

/**
 * 与对应负数同时存在的最大正整数
 *
 * @author i323779
 */
public class Solution2441 {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        // 双指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < 0) {
                left++;
            } else if (nums[left] + nums[right] > 0) {
                right--;
            } else {
                return nums[right];
            }
        }
        return -1;
    }
}
