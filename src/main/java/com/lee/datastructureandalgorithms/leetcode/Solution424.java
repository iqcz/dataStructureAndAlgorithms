package com.lee.datastructureandalgorithms.leetcode;

/**
 * 经典
 * @author D49450
 */
public class Solution424 {

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println("characterReplacement(s, 2) = " + characterReplacement(s, 2));

        char a = 'A';
        System.out.println(a);
        int iA = a;
        System.out.println("iA = " + iA);
    }

    public static int characterReplacement(String str, int k) {
        int res = 0;
        int tmpMax = 0;
        int[] counts = new int[26];

        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'A']++;
            tmpMax = Math.max(tmpMax, counts[str.charAt(i) - 'A']);

            if (res - tmpMax < k) {
                res++;
            } else {
                counts[str.charAt(i - res) - 'A']--;
            }
        }
        return res;
    }
}
