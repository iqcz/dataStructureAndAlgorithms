package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author osyuj
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        boolean seeTwice = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[left] != nums[i]) {
                left++;
                // 指针后移
                nums[left] = nums[i];
            } else {
                if (!seeTwice) {
                    left++;
                    nums[left] = nums[i];
                    seeTwice = true;
                }
            }
        }
        return left + 1;
    }
}
