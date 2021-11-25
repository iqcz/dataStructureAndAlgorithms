package com.lee.datastructureandalgorithms.tuling.leetcode;

/**
 * 排列硬币
 * 总共有 n 枚硬币，将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内
 *
 * @author D49450
 */
public class Sample13 {
    public static void main(String[] args) {
        System.out.println("arrangeCoins(6) = " + arrangeCoins(6));
        System.out.println("arrangeCoins2(6) = " + arrangeCoins2(6));
    }

    public static int arrangeCoins(int n) {
        for (int i = 1; i <= n; i++) {
            n = n - 1;
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 二分查找
     *
     * @param n
     * @return
     */
    public static int arrangeCoins2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int cost = (mid + 1) * mid / 2;
            if (cost == n) {
                return mid;
            } else if (cost > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
