package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 翻转字符串里的单词
 * @author D49450
 */
public class Solution151 {

    /**
     * 使用JDK自带API
     * @param s
     * @return
     */
    public static String reverseWordsInJDK(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "the sky   is     blue ";
        System.out.println("reverseWordsInJDK(s) = " + reverseWordsInJDK(s));
    }
}
