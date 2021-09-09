package com.lee.datastructureandalgorithms.tuling.leetcode;

/**
 * 最长连续递增序列
 * 给定要给未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
 * 贪心算法
 * @author osyuj
 */
public class Sample19 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 3, 4, 3, 4, 5, 6, 7};
        System.out.println("findLength(nums) = " + findLength(nums));
    }

    public static int findLength(int[] nums) {
        int start = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                start = i;
            }
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
}