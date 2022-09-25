package com.lee.datastructureandalgorithms.leetcode;

/**
 * 最长公共前缀
 *
 * @author D49450
 */
public class Solution14 {
    /**
     * 纵向比较法
     *
     * @param strs 字符串数组
     * @return 最长公共子串
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
