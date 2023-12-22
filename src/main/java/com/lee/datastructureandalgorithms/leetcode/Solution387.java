package com.lee.datastructureandalgorithms.leetcode;

/**
 * 字符串中的第一个唯一字符
 *
 * @author D49450
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        Solution387 solution387 = new Solution387();
        int index = solution387.firstUniqChar(s);
        System.out.println("index = " + index);
    }
}
