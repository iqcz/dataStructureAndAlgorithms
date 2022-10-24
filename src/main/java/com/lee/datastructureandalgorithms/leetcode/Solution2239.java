package com.lee.datastructureandalgorithms.leetcode;

/**
 *
 * 找到最接近 0 的数字
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值。
 *
 * @author D49450
 */
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
