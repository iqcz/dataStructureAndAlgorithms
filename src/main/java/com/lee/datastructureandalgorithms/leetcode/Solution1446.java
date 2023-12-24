package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution1446 {
    public int maxPower(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 1;
        int ans = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 1;
            }
        }
        return ans;
    }

}
