package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution344 {

    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    public static void main(String[] args) {
        String str = "hello, world";
        char[] chars = str.toCharArray();
        Solution344 solution344 = new Solution344();
        solution344.reverseString(chars);
        System.out.println(new String(chars));
    }

    public void reverseString1(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
