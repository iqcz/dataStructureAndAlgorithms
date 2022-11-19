package com.lee.datastructureandalgorithms.leetcode;

public class Solution905 {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        // 额外创建了一个数组
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }
}
