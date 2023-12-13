package com.lee.datastructureandalgorithms.leetcode;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 *
 * @author D49450
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> frequencies = Maps.newHashMap();

        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int num = entry.getKey();
            int occ = entry.getValue();

            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}
