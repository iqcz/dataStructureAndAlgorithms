package com.lee.datastructureandalgorithms.leetcode;

/**
 * 接雨水
 *
 * @author D49450
 */
public class Solution42 {
    public int trap(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                result += leftMax - height[left];
                ++left;
            } else {
                result += rightMax - height[right];
                --right;
            }
        }
        return result;
    }
}