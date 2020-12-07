package com.lee.datastructureandalgorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution217 solution217 = new Solution217();
//        int[] data = {1, 2, 3, 1};
//        int[] data = {1, 2, 3, 4};
        int[] data = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(solution217.containsDuplicate(data));
    }
}
