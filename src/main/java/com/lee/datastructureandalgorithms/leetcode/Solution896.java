package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution896 {
    public boolean isMonotonic(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i + 1]);
            if (c != 0) {
                if (c != store && store != 0) {
                    return false;
                }
                store = c;
            }
        }
        return true;
    }
}
