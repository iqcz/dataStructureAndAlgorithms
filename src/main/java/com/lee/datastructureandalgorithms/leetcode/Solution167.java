package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

/**
 * 思路：双指针
 * 1，初始状态下，令left指向数组的第一个元素，right指向数组的最后一个元素
 * 2，进入循环，控制循环退出条件为left >= right
 * 3，在每一次循环中，如果left与right的数字之和等于所给的target，则返回当前的left和right
 * 4，若left与right之和小于target，则left++，继续循环
 * 5，若left与right之和大于target，则right--，继续循环
 */
public class    Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution167.twoSum(numbers, 9)));
    }
}
