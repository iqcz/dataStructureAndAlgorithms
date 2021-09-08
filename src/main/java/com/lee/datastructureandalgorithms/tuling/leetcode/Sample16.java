package com.lee.datastructureandalgorithms.tuling.leetcode;

/**
 * 子数组平均最大数
 * 给定一个整型数组，找出平均数最大长度为k的下标连续的子数组，并输出该最大平均数。
 * <p>
 * 滑动窗口来实现
 *
 * @author osyuj
 */
public class Sample16 {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println("findMaxAverage(nums, 4) = " + findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        // 先计算第一个滑动窗口的和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < length; i++) {
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(max, sum);
        }
        return 1D * max / k;
    }
}