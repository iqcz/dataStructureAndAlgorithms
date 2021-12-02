package com.lee.datastructureandalgorithms.offer;

/**
 * @author D49450
 */
public class Question12 {

    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum - nums[i] == total - sum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 2, 9};
        System.out.println(pivotIndex(nums));
    }
}