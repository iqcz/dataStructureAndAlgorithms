package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return -1;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // 不相等的情况下，用后面的元素覆盖前面的元素
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] arr = {4, 9, 4, 8, 0};
        System.out.println(solution27.removeElement(arr, 4));
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
