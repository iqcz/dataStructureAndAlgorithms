package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}