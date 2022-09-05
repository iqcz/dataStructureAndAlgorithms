package com.lee.datastructureandalgorithms.leetcode;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * @author D49450
 */
public class Solution509 {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        System.out.println(solution509.fib(9));
    }
}
