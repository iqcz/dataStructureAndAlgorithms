package com.lee.datastructureandalgorithms.leetcode;

/**
 * 3 的幂
 *
 * @author D49450
 */
public class Solution326 {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        Solution326 s = new Solution326();
        boolean powerOfThree = s.isPowerOfThree(45);
        System.out.println("powerOfThree = " + powerOfThree);
    }
}
