package com.lee.datastructureandalgorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 解题思路：sliding window
 * 1，创建一个set；
 * 2，两个指针，第一个指向字符串的开头（j），第二个随着for循环遍历字符串（i）；
 * 3，如果set里面没有s[i]，说明目前为止还有没有重复的字符，把s[i]添加到set中，然后更新最大不重复字符的长度；
 * 4，如果set里有set[i]，则从set里开始删除set[j]，并且递增j，再检查set里是否有set[i]，如此反复直到set里没有set[i]为止。
 * 5，重复步骤3和4，直到遍历完整个字符串。
 *
 * @author i324779
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution3.lengthOfLongestSubstring1("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        // 滑动窗口左下标
        int leftIndex = 0;
        int maxLength = 0;

        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            if (!set.contains(c)) {
                set.add(c);
                maxLength = Math.max(maxLength, set.size());
            } else {
                while (set.contains(charArr[leftIndex])) {
                    set.remove(charArr[leftIndex]);
                    leftIndex++;
                }
                set.add(c);
            }
        }

        return maxLength;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        while (right < s.length() && left < s.length() - res) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}

