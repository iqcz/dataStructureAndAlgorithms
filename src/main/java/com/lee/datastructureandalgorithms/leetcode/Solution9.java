package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        // eg: 10, 100
        if (x % 10 == 0) {
            return false;
        }

        // 反转
        int res = 0;
        int copy = x;
        while (x > 0) {
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        return copy == res;
    }

    /*
    1: res = 0 + 3; x = 12;
    2: res = 30 + 2 = 32; x = 1;
    3: res = 320 + 1 = 321; x = 0;
     */
}
