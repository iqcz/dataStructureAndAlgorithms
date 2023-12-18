package com.lee.datastructureandalgorithms.leetcode;

/**
 * 交替合并字符串
 *
 * @author D49450
 */
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) {
            return word2;
        }

        if (word2 == null || word2.isEmpty()) {
            return word1;
        }

        StringBuilder mergeWords = new StringBuilder();
        char[] charWord1 = word1.toCharArray();
        char[] charWord2 = word2.toCharArray();
        for (int i = 0; i < Math.min(charWord1.length, charWord2.length); i++) {
            mergeWords.append(charWord1[i]).append(charWord2[i]);
        }

        if (charWord1.length > charWord2.length) {
            mergeWords.append(word1, charWord2.length, charWord1.length);
        } else {
            mergeWords.append(word2, charWord1.length, charWord2.length);
        }

        return mergeWords.toString();
    }
}