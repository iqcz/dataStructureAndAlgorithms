package com.lee.datastructureandalgorithms.leetcode;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int cost = 0;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min((cost), price);
            profit = Math.max(profit, profit - cost);
        }
        return profit;
    }
}
