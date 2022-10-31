package com.lee.datastructureandalgorithms.leetcode;

/**
 *  旋转字符串
 * @author i324779
 */
public class Solution796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    // todo another one.
}