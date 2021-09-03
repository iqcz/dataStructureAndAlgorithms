package com.lee.datastructureandalgorithms.tuling.leetcode;

/**
 * 统计素数个数，使用埃式筛选
 *
 * @author i324779
 */
public class Sample04 {
    public static void main(String[] args) {
        System.out.println("eratosthenes(100) = " + eratosthenes(100));
    }

    public static int eratosthenes(int n) {
        // 默认false代表素数
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                // j就是合数的标记位
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        return count;
    }
}
