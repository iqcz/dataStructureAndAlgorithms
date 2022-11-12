package com.lee.datastructureandalgorithms.leetcode;

/**
 * 旋转字符串
 *
 * @author i324779
 */
public class Solution796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public boolean rotateString1(String s, String goal) {
        int sLength = s.length();
        int goalLength = goal.length();
        // 比较长度
        if (sLength != goalLength) {
            return false;
        }

        for (int i = 0; i < goalLength; i++) {
            boolean flag = true;
            for (int j = 0; j < goalLength; j++) {
                // 很巧妙
                if (s.charAt((i + j) % goalLength) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}