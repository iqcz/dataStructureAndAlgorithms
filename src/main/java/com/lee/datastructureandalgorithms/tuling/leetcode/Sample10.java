package com.lee.datastructureandalgorithms.tuling.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和，无序数组
 * 给定一个升序排列的整数数组 numbers ，从数组中找出两个数满足相加之和等于目标数 target 。
 * 假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
 * 返回两数的下标值，以数组形式返回
 *
 * @author osyuj
 */
public class Sample10 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 7};
        System.out.println(Arrays.toString(twoSum(nums, 7)));
        System.out.println(Arrays.toString(twoSumImprove(nums, 7)));
    }

    /**
     * 暴力方式
     *
     * @param sums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] sums, int target) {
        for (int i = 0; i < sums.length; i++) {
            for (int j = i; j < sums.length; j++) {
                if (sums[i] + sums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 使用hashmap进行标记
     * @param sums
     * @param target
     * @return
     */
    public static int[] twoSumImprove(int[] sums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);

        for (int i = 0; i < sums.length; i++) {
            if (map.containsKey(target - sums[i])) {
                return new int[]{map.get(target - sums[i]), i};
            }
            map.put(sums[i], i);
        }
        return new int[]{-1, -1};
    }
}
