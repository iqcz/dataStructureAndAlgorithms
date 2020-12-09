package com.lee.datastructureandalgorithms.leetcode;

public class Solution867 {
    public int[][] transpose(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        }
        return ans;
    }
}