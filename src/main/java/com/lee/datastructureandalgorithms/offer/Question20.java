package com.lee.datastructureandalgorithms.offer;

/**
 * @author D49450
 */
public class Question20 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        Question20 question20 = new Question20();
        String s = "aaa";
        System.out.println("countSubstrings(s) = " + question20.countSubstrings(s));

    }
}
