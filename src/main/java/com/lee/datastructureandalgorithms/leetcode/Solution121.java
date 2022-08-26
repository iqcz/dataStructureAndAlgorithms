package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}