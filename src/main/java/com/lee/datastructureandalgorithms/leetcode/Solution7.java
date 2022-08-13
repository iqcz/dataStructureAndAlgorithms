package com.lee.datastructureandalgorithms.leetcode;

/**
 * 反转数字
 *
 * @author D49450
 */
public class Solution7 {
    public static void main(String[] args) {
        System.out.println("reverse(123) = " + reverse(-1345));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            // 考虑溢出
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
