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

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] data = {-7, -3, 2, 3, 11};
//        Solution977 solution977 = new Solution977();
//        System.out.println(Arrays.toString(solution977.sortedSquares(data)));
//        System.out.println(Arrays.toString(solution977.sortedSquares1(data)));

        int [] [] data1 = new int[2][5];
        for (int i = 0; i < data1.length;i++) {
            for (int j = 0; j < data1[i].length; j++) {
                data1[i][j] = i * j;
            }
        }
        for (int i = 0; i < data1.length;i++) {
            for (int j = 0; j < data1[i].length; j++) {
//                System.out.print("data1[" + i + "][" + j + "] = " + data1[i][j]);
                System.out.print(data1[i][j]);
            }
            System.out.println();
        }
    }
}
