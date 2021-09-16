package com.lee.datastructureandalgorithms.tuling;

/**
 * 动态规划问题
 * 背包问题
 *
 * @author osyuj
 */
public class DP {
    public static void main(String[] args) {
        // 物品价值
        int[] values = {60, 100, 120};
        // 物品重量
        int[] weights = {10, 20, 40};

        // 重量
        int w = 50;
        // 物品
        int n = 3;
        //n表示是物品，w表示重量,初始化全是0
        int dp[][] = new int[n + 1][w + 1];

        // 每次加的物品
        for (int i = 1; i <= n; i++) {
            //分割的背包
            for (int cw = 1; cw <= w; cw++) {
                //表示这个物品可以装进去
                if (weights[i - 1] <= cw) {
                    dp[i][cw] = Math.max(values[i - 1] + dp[i - 1][cw - weights[i - 1]], dp[i - 1][cw]);
                } else {
                    //不能装
                    dp[i][cw] = dp[i - 1][cw];
                }
            }
        }
        System.out.println(dp[n][w]);
    }
}

