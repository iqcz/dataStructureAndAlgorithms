package com.lee.datastructureandalgorithms.leetcode;

/**
 *
 * 本题其实是排序题目的变种，是一道披着数字外衣的排序题。
 * @author D49450
 */
public class Solution191 {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("hammingWeight(15) = " + hammingWeight(15));
    }
}