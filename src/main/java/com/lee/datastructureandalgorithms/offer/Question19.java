package com.lee.datastructureandalgorithms.offer;

/**
 * @author D49450
 */
public class Question19 {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (; start < s.length() / 2; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }

        return start == s.length() / 2
                || isPalindrome(s, start, end - 1)
                || isPalindrome(s, start + 1, end);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
        Question19 question19 = new Question19();
        System.out.println("question19.validPalindrome(\"abca\") = " + question19.validPalindrome("abca"));
    }
}