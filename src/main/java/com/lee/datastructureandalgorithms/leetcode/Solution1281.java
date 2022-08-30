package com.lee.datastructureandalgorithms.leetcode;

/**
 * 整数的各位积和之差
 *
 * @author i324779
 */
public class Solution1281 {
    public int subtractProductAndSum(int n) {
        int add = 0;
        int mul = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            add += digit;
            mul *= digit;
        }
        return mul - add;
    }
}
