package com.lee.datastructureandalgorithms.leetcode;

public class Solution416 {
    /**
     * 基于LeetCode的官方代码，做了简单调整
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // 数组元素只有0个或者1个，直接返回false
        if (n < 2) {
            return false;
        }
        // 数组元素只有2个，直接判断
        if (n == 2) {
            return nums[0] == nums[1];
        }
        // sum统计数组元素和，maxNum记录数组最大数值元素
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        // sum为奇数，是不可能分为和相等的两个子集
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        // 数组最大数值大于数组元素和的一半，是不可能分为和相等的两个子集
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            //数组存在元素大于数组元素和的一半，是不可能分为和相等的两个子集
            // 数组存在元素等于数组元素和的一半，一定可以分为相等的两个子集
            if (num >= target) return num <= target;
            for (int j = target; j >= num; --j) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}