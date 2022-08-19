package com.lee.datastructureandalgorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author D49450
 */
public class Solution128 {

    /**
     * 利用哈希表
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        // 遍历数组，建立哈希表，同时去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            longest = Math.max((longest), cur - num + 1);
        }
        return longest;
    }
}