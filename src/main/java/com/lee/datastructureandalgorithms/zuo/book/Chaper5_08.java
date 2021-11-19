package com.lee.datastructureandalgorithms.zuo.book;

/**
 * @author D49450
 * 翻转字符串
 */
public class Chaper5_08 {
    public static void main(String[] args) {
        String str = "dogs loves pig";
//        String str = "I'm a student.";

        char[] chars = str.toCharArray();
        rotateWord(chars);
        String rotatedString = new String(chars);
        System.out.println("rotatedString = " + rotatedString);

    }

    public static void rotateWord(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        // 整体逆序
        reverse(chars, 0, chars.length - 1);
        // gip sevol god
        int left = -1;
        int right = -1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                left = i == 0 || chars[i - 1] == ' ' ? i : left;
                right = i == chars.length - 1 || chars[i + 1] == ' ' ? i : right;
            }
            if (left != -1 && right != -1) {
                // 每个单词再逆序复位
                reverse(chars, left, right);
                left = -1;
                right = -1;
            }
        }
    }

    private static void reverse(char[] chars, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
