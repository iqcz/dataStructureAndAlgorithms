package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution28 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        boolean seeTwice = false;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                seeTwice = false;
                left++;
                nums[left] = nums[right];
            } else {
                if (!seeTwice) {
                    left++;
                    nums[left] = nums[right];
                    seeTwice = true;
                }
            }
        }
        return left + 1;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}