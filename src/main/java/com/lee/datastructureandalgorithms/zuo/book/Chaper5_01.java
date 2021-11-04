package com.lee.datastructureandalgorithms.zuo.book;

import com.google.common.base.Strings;

/**
 * @author D49450
 * 判断两个字符串是否互为变形词
 */
public class Chaper5_01 {

    /**
     * by myself
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isDeformation(String str1, String str2) {
        if (Strings.isNullOrEmpty(str1) || Strings.isNullOrEmpty(str2)) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        char [] char1 = str1.toCharArray();
        char [] char2 = str2.toCharArray();

        int [] map = new int[256];
        for (char value : char1) {
            map[value]++;
        }

        for (char c : char2) {
            map[c]--;
        }

        for( int d : map) {
            if (d < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDeformation1(String str1, String str2) {
        if (Strings.isNullOrEmpty(str1) || Strings.isNullOrEmpty(str2)) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        char [] char1 = str1.toCharArray();
        char [] char2 = str2.toCharArray();

        int [] map = new int[256];
        for (char value : char1) {
            map[value]++;
        }

        for (char c : char2) {
            if (map[c]-- == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "1213";
        String str2 = "3121";

        System.out.println(isDeformation(str1, str2));
        System.out.println(isDeformation1(str1, str2));
    }
}
