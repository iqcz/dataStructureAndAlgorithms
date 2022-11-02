package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution28 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        boolean seeTwice = false;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                seeTwice = false;
                left++;
                nums[left] = nums[right];
            } else {
                if (!seeTwice) {
                    left++;
                    nums[left] = nums[right];
                    seeTwice = true;
                }
            }
        }
        return left + 1;
    }

    public int strStr(String haystack, String needle) {
        return -1;
    }
}