package com.lee.datastructureandalgorithms.leetcode;

/**
 * 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 *
 * @author D49450
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] cnt = new int[26];

        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
