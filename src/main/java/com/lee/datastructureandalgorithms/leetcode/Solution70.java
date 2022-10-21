package com.lee.datastructureandalgorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 *
 * @author D49450
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 使用map保存每次计算的结果，避免重复计算
     * 递归方式
     */
    private final Map<Integer, Integer> storeMap = new HashMap<>(16);

    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }

        if (storeMap.get(n) != null) {
            return storeMap.get(n);
        }
        int result = climbStairs1(n - 1) + climbStairs1(n - 2);
        storeMap.put(n, result);

        return result;
    }

    /**
     * 迭代方式
     * 自底向上累加
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println("solution70.climbStairs(5) = " + solution70.climbStairs(5));
        System.out.println("solution70.climbStairs1(5) = " + solution70.climbStairs1(5));
        System.out.println("solution70.climbStairs2(5) = " + solution70.climbStairs2(5));
    }
}
