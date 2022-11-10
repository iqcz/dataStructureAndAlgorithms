package com.lee.datastructureandalgorithms.leetcode;

/**
 * x 的平方根
 * @author i324779
 */
public class Solution69 {
    public int mySqrt(int x) {
        long l = 0;
        long h = x;
        while (l <= h) {
            long mid = l + (h - l) / 2;
            if (l == h || l + 1 == h) {
                break;
            } else if (mid * mid > x) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        if (h * h <= x) {
            return (int) h;
        } else {
            return (int) l;
        }
    }
}
