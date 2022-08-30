package com.lee.datastructureandalgorithms.leetcode;

/**
 *  同构字符串
 * @author D49450
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
