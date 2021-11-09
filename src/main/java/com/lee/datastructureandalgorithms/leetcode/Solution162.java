package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution162 {
    public static int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle + 1 < length && nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else if (middle - 1 >= 0 && nums[middle] < nums[middle - 1]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 1};
        System.out.println("findPeakElement(data) = " + findPeakElement(data));
    }
}
