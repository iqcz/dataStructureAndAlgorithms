package com.lee.datastructureandalgorithms.leetcode;


/**
 * @author D49450
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        while (index >= 0) {
            if (chars[index] == ' ') {
                index--;
            } else {
                break;
            }
        }
        int count = 0;
        for (int i = index; i >= 0; i--) {
            if (chars[i] == ' ') {
                break;
            }
            count++;
        }

        return count;
    }
}
