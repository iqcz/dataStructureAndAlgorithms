package com.lee.datastructureandalgorithms.tuling.leetcode;

import java.util.Arrays;

/**
 * 两数之和2
 *
 * @author osyuj
 */
public class Sample11 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 7, 11};
        System.out.println(Arrays.toString(twoSumWithSorted(nums, 18)));
    }

    public static int[] twoSumWithSorted(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int sum = 0;
        while (low < high) {
            sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{-1, -1};
    }
}
