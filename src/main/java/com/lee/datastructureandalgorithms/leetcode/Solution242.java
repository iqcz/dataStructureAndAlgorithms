package com.lee.datastructureandalgorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 第一种方式：两个字符串排序，再比较
 * 第二种方式：使用 map{letter：count}
 * @author i324779
 */
public class Solution242 {

    public static void main(String[] args) {
        Solution242 solution242 = new Solution242();
        System.out.println(solution242.isAnagram("abc", "cba"));
    }
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return  false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        // 使用map计数
        Map<Character, Integer> sMap = new HashMap<>(16);
        Map<Character, Integer> tMap = new HashMap<>(16);
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        if (sMap.size() != tMap.size()) {
            return false;
        }
        // 最后比较map
        return sMap.equals(tMap);
    }
}
