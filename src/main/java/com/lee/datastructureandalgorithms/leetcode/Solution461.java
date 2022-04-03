package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution461 {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        for (int xor = x ^ y; xor != 0; xor &= (xor - 1)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("hammingDistance(1, 4) = " + hammingDistance(1, 4));
    }
}