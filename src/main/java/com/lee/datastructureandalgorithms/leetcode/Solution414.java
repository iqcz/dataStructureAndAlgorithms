package com.lee.datastructureandalgorithms.leetcode;

import java.util.TreeSet;

/**
 * 第三大的数
 *
 * @author D49450
 */
public class Solution414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }

    public static void main(String[] args) {
        Solution414 s = new Solution414();
//        int [] nums = {3, 2, 1};
        int[] nums = {2, 2, 1, 3};
        System.out.println("s.thirdMax(nums) = " + s.thirdMax(nums));
    }
}
