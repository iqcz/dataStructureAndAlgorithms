package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxWater = 0;
        while (i < j) {
            maxWater = height[i] < height[j]
                    ?
                    Math.max(maxWater, (j - i) * height[i++])
                    :
                    Math.max(maxWater, (j - i) * height[j--]);
        }
        return maxWater;
    }
}