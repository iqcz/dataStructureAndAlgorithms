package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

/**
 * 最小数字游戏
 * @author alphayosemite
 */
public class Solution2974 {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 2) {
            int tmp = nums[i - 1];
            nums[i - 1] = nums[i];
            ;
            nums[i] = tmp;
        }
        return nums;
    }
}
