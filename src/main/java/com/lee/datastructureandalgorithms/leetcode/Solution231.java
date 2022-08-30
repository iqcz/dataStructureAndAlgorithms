package com.lee.datastructureandalgorithms.leetcode;

/**
 * 2 的幂
 * @author D49450
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
