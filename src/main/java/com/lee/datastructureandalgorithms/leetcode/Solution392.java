package com.lee.datastructureandalgorithms.leetcode;

/**
 * 判断子序列
 * 双指针
 * @author D49450
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int i = 0;
        int j = 0;

        while (i < sLength && j < tLength) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLength;
    }
}
