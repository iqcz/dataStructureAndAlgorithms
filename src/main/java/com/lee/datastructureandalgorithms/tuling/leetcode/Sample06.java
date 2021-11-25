package com.lee.datastructureandalgorithms.tuling.leetcode;

import java.util.Arrays;

/**
 * 寻找数组的中心索引
 * 数组中某一个下标，左右两边的元素之后相等，该下标即为中心索引
 *
 * @author D49450
 */
public class Sample06 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6, 2, 6,9};
        System.out.println("pivotIndex(nums) = " + pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }
}
