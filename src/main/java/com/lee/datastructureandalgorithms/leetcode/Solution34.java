package com.lee.datastructureandalgorithms.leetcode;

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        if (result[0] == -1) {
            return new int[]{-1, -1};
        }
        result[1] = findLast(result[0], nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                idx = mid;
            }
        }
        return idx;
    }

    private int findLast(int first, int[] nums, int target) {
        int idx = -1;
        int start = first;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) {
                idx = mid;
            }
        }
        return idx;
    }

    static double sum = 0D;
    public static void main(String[] args) {
        for (int i = 0; i < 0x77777777; i++) { // counted loop
            sum += Math.log(i); // Math.log is an intrinsic
        }
    }
}