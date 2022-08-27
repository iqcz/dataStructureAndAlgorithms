package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
