package com.lee.datastructureandalgorithms.leetcode;

/**
 * 验证回文字符串II
 *
 * @author D49450
 */
public class Solution680 {
    private boolean isPalindrome(String s, int i, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (left == i) {
                left += 1;
            } else if (right == i) {
                right -= 1;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, n) || isPalindrome(s, right, n);
            }
            left++;
            right--;
        }
        return true;
    }
}
