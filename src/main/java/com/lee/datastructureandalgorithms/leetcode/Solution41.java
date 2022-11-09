package com.lee.datastructureandalgorithms.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * 缺失的第一个正数
 * 还有好多方式
 *
 * @author D49450
 */
@Slf4j
public class Solution41 {
    public static void main(String[] args) {
        int[] data = {-12, -3, 0, 1, 4, 9};
        log.info("firstMissingPositive: {}", firstMissingPositive(data));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= len; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return len + 1;
    }
}