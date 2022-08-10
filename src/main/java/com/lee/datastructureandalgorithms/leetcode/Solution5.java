package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author i324779
 */
public class Solution5 {
    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        String res = s.substring(0, 1);
        for (int i = 0; i < n - 1; i++) {
            String e1 = extend(i, i, s);
            String e2 = extend(i, i + 1, s);
            if (Math.max(e1.length(), e2.length()) > res.length()) {
                res = ((e1.length() > e2.length()) ? e1 : e2);
            }
        }
        return res;
    }

    private static String extend(int i, int j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    // 也可以使用动态规划法

    public static void main(String[] args) {
        String str = "aabbcc";
        System.out.println("longestPalindrome(str) = " + longestPalindrome(str));

    }
}

