package com.lee.datastructureandalgorithms.leetcode;

/**
 * 二分查找
 *
 * @author D49450
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // bad code
        // too bad code.

        // 2nd bad code
        // 2nd too bad code.
    }
}
