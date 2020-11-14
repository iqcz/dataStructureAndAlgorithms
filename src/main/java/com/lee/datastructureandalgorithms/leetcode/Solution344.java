package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author osyuj
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
}
