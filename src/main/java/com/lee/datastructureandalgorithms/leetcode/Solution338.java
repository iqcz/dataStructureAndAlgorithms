package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution338 {
    public int[] countBits(int n) {
        int[] results = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            results[i] = results[i & (i - 1)] + 1;
        }
        return results;
    }
}