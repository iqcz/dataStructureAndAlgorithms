package com.lee.datastructureandalgorithms.leetcode;

/**
 * 删除排序数组中的重复项
 *
 * @author osyuj
 */
public class Solution26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}
