package com.lee.datastructureandalgorithms.leetcode;


/**
 * @date 2022-10-26 SH_PD_AP 2 PK
 * @author D49450
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        char[] chars = s.toCharArray();
        // 最大长度
        int index = chars.length - 1;
        // 去掉最后一个单词后面的空格，只统计有效的字符个数
        while (index >= 0) {
            if (chars[index] == ' ') {
                // 如果遇到空格，减少最大长度
                index--;
            } else {
                // 遇到了字母，则跳出循环
                break;
            }
        }
        int count = 0;
        //从后往前遍历
        for (int i = index; i >= 0; i--) {
            if (chars[i] == ' ') {
                // 遇到了空格，说明最后一个单词的开始位置已经结束
                break;
            }
            count++;
        }

        return count;
    }
}
