package com.lee.datastructureandalgorithms.leetcode;

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new Solution35().searchInsert(nums, 5));
    }
}