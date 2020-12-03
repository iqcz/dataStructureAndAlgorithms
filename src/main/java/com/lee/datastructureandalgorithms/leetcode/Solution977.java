package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] powerData = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            powerData[i] = nums[i] * nums[i];
        }

        Arrays.sort(powerData);
        return powerData;
    }

    public static void main(String[] args) {
        int[] data = {-7,-3,2,3,11};
        Solution977 solution977 = new Solution977();
        System.out.println(Arrays.toString(solution977.sortedSquares(data)));
    }
}
