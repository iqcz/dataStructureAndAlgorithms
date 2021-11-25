package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

/**
 * @author D49450
 */
public class Solution66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne1(int[] digits) {
        // 1999
        // 1001
        // 999
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
//        int[] digits = {1, 2, 3};
//        int[] digits = {1, 2, 3};
        int[] digits = {8, 9, 9};
        Solution66 solution66 = new Solution66();
        System.out.println(Arrays.toString(solution66.plusOne(digits)));

    }
}
