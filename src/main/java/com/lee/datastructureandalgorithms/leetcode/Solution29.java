package com.lee.datastructureandalgorithms.leetcode;

/**
 * 两数相除
 *
 * @author D49450
 * <p>
 * beijing shoudu airport
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean isSame = true;
        if (dividend > 0) {
            dividend = -dividend;
            isSame = false;
        }
        if (divisor > 0) {
            divisor = -divisor;
            isSame = !isSame;
        }
        int index = 0;
        int current = divisor;
        while (current >= dividend - current) {
            current += current;
            ++index;
        }
        int ans = 0;
        for (int i = index; i >= 0; i--) {
            if (current >= dividend) {
                ans += 1 << i;
                dividend -= current;
            }
            current >>= 1;
        }
        return isSame ? ans : -ans;
    }
}
