package com.lee.datastructureandalgorithms.offer;

/**
 * 输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度。例如，输入字符串" babcca"，
 * 其最长的不含重复字符的子字符串是"abc"，长度为3。
 */
public class Chapter16 {
    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubString(\"babcca\") = " + lengthOfLongestSubString("babcca"));
    }

    public static int lengthOfLongestSubString(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;

        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            while (hasGreaterThan1(counts)) {
                ++j;
                counts[s.charAt(j)]--;
            }
            longest = Math.max((i - j), longest);
        }
        return longest;
    }

    private static boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
