package com.lee.datastructureandalgorithms.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution15 {

    /**
     * 考虑双指针；
     * 排序；
     * 一层循环固定一个元素，循环内部利用双指针找出剩下的两个元素。
     * 注意：去重；
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Lists.newArrayList();
        }

        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left += 1;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right -= 1;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }
                    left += 1;
                    right -= 1;
                }
            }
        }
        return res;
    }
}
