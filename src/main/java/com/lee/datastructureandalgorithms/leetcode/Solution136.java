package com.lee.datastructureandalgorithms.leetcode;

/**
 * 只出现一次的数字
 *
 * @author D49450
 */
public class Solution136 {
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] data = {2, 2, 7, 4, 5, 4, 7};
        System.out.println("singleNumber(data) = " + singleNumber(data));

        int a = 4 ^ 3 ^ 4 ^ 3 ^ 8;
        System.out.println(a);
    }
}