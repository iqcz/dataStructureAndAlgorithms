package com.lee.datastructureandalgorithms.leetcode;

/**
 * 单调递增的数字
 *
 * @author D49450
 */
public class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;
        int index = length;

        for (int i = length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                index = i - 1;
                digits[index]--;
            }
        }

        for (int i = index + 1; i < length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(String.valueOf(digits));
    }

    public static void main(String[] args) {
        Solution738 solution738 = new Solution738();
        int num = solution738.monotoneIncreasingDigits(10);
        System.out.println("num = " + num);
    }
}
