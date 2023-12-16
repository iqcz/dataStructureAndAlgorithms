package com.lee.datastructureandalgorithms.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 单词规律
 *
 * @author D49450
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }

        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (!Objects.equals(map.put(strings[i], i), map.put(pattern.charAt(i), i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution290 s = new Solution290();
        boolean b = s.wordPattern("abba", "dog cat cat dog");
        System.out.println("b = " + b);

        Map<String, Integer> map = new HashMap<>();
        Integer one = map.put("one", 1);
        System.out.println("one = " + one);
        Integer two = map.put("two", 2);
        System.out.println("two = " + two);

        Integer one1 = map.put("one", 1);
        System.out.println("one1 = " + one1);
    }
}
