package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查找共用字符
 *
 * @author i324779
 */
public class Solution1002 {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : words[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            String str = words[i];
            Map<Character, Integer> map2 = new HashMap<>();
            for (Character c : str.toCharArray()) {
                if (map.containsKey(c)) {
                    // 去重
                    map2.put(c, Math.min(map2.getOrDefault(c, 0) + 1, map.get(c)));
                }
            }
            map = map2;
        }

        map.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                result.add(String.valueOf(key));
            }
        });
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
//        String[] words = {"cool", "lock", "cook"};
        Solution1002 solution1002 = new Solution1002();

        List<String> result = solution1002.commonChars(words);
        System.out.println("result = " + result);
    }
}
