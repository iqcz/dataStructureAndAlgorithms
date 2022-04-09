package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution55 {

    /**
     * 动态规划dp
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxStep = nums[0];
        for (int i = 1; i < n; i++) {
            if (maxStep == 0) {
                return false;
            }
            maxStep = Math.max(maxStep - 1, nums[i]);
        }
        return true;
    }
}
