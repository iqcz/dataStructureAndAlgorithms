package com.lee.datastructureandalgorithms.tuling.leetcode;

import java.util.Arrays;

/**
 * 一个整型数组 nums ，在数组中找出由三个数字组成的最大乘积，并输出这个乘积。
 *
 * @author D49450
 */
public class Sample09 {
    public static void main(String[] args) {
        int[] nums = {-9, -5, 2, 4, 7};
        System.out.println("maxBySort(nums) = " + maxBySort(nums));
    }

    public static int maxBySort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[0] * nums[1] * nums[length - 1],
                nums[length - 1] * nums[length - 2] * nums[length - 3]);
    }
}
