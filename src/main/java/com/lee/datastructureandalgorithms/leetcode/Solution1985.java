package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

/**
 * 找出数组中的第 K 大整数
 *
 * @author D49450
 */
public class Solution1985 {
    public String kthLargestNumber(String[] nums, int k) {
        // 倒序排列
        Arrays.sort(nums, (o1, o2) -> {
            int o1Length = o1.length();
            int o2Length = o2.length();

            if (o1Length != o2Length) {
                return o2Length - o1Length;
            }
            return o2.compareTo(o1);
        });
        return nums[k - 1];
    }

    public static void main(String[] args) {
        Solution1985 s1 = new Solution1985();
        String [] nums = {"3","6","7","10"};

        System.out.println("kthLargestNumber(nums, 4) = " + s1.kthLargestNumber(nums, 4));
    }
}
