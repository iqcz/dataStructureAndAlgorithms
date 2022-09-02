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
        int result = 0;

        // 注意这个判断条件
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            // 考虑溢出
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + digit;
        }
        return result;
    }
}
