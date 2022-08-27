package com.lee.datastructureandalgorithms.leetcode;

public class Solution2239 {
    public int findClosestNumber(int[] nums) {
        int res = nums[0];
        for (int n : nums) {
            if (Math.abs(n) == Math.abs(res)) {
                res = Math.max(n, res);
            } else if (Math.abs(n) < Math.abs(res)) {
                res = n;
            }
        }
        return res;
    }
}
