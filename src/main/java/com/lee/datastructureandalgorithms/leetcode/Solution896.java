package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution896 {
    public boolean isMonotonic(int[] nums) {
        int store = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            int c = Integer.compare(nums[i], nums[i + 1]);
            if (c != 0) {
                if (c != store && store != 0) {
                    return false;
                }
                store = c;
            }
        }
        return true;
    }

    public boolean isMonotonic1(int[] nums) {
        boolean increase = false;
        boolean decrease = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                decrease = true;
            }
            if (nums[i] > nums[i - 1]) {
                increase = true;
            }
        }
        return !increase || !decrease;
    }
}
