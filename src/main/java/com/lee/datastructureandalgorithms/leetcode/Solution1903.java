package com.lee.datastructureandalgorithms.leetcode;

/**
 * 字符串中的最大奇数
 * @author D49450
 */
public class Solution1903 {
    public String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; --i) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                // 找到第一个值为奇数的字符，返回 num[0:i+1]
                return num.substring(0, i + 1);
            }
        }
        // 未找到值为奇数的字符，返回空字符串
        return "";
    }
}
