package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 2};
        int[] nums2 = {10, 43, 29, 3, 14};
        Solution349 solution349 = new Solution349();
        System.out.println("Arrays.toString(solution349.intersection(nums1, nums2)) = " + Arrays.toString(solution349.intersection(nums1, nums2)));
    }
}
