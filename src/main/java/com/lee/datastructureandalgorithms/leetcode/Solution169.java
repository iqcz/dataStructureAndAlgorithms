package com.lee.datastructureandalgorithms.leetcode;

/**
 * 每两个，消消乐。
 * 或者像，在游戏里面，相同级别的棋子直接对棋。
 * @author D49450
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        // 对拼消耗的数字
        int currentNum = nums[0];
        // 对拼消耗的数字的个数
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                // 对拼消耗的数字设置为当前元素
                currentNum = nums[i];
                count++;
            } else {
                if (currentNum == nums[i]) {
                    // 对拼消耗的数字个数加一
                    count++;
                } else {
                    // 数组不等，兑棋子，对拼消耗的数字减一
                    count--;
                }
            }
        }
        return currentNum;
    }
}
