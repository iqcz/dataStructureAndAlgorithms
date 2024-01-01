package com.lee.datastructureandalgorithms.leetcode;

/**
 * 寻找两个正序数组的中位数
 * back to bj from sh.
 *
 * @author D49450
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        int mergedLength = nums1Length + nums2Length;

        // 保存当前循环的结果
        int left = -1;
        //  更新为最后一次循环的结果
        int right = -1;

        int nums1Start = 0;
        int nums2Start = 0;

        for (int i = 0; i <= mergedLength / 2; i++) {
            left = right;
            if (nums1Start < nums1Length && (nums2Start >= nums2Length || nums1[nums1Start] < nums2[nums2Start])) {
                right = nums1[nums1Start++];
            } else {
                right = nums2[nums2Start++];
            }
        }

        // 判断奇偶
        if ((mergedLength & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
