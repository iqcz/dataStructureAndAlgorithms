package com.lee.datastructureandalgorithms.leetcode;

import java.util.HashSet;

/**
 * 删除子数组的最大得分
 *
 * @author D49450
 */
public class Solution1695 {
    /**
     * 滑动窗口 + 哈希表
     */
    public int maximumUniqueSubarray(int[] nums) {
        // 定义当前滑动窗口元素和
        int sums = 0;
        // 滑动过程中得出的最大得分
        int largest = 0;
        // 因为需要去重，因此需要一个哈希表
        HashSet<Integer> hash = new HashSet<>();
        // 定义窗口的首端和尾端
        int start = 0;
        for (int num : nums) {
            // 如果哈希表中存储了即将加入滑动窗口的元素
            while (hash.contains(num)) {
                // 需要不断的把窗口的左边元素移除窗口
                // 元素和需要减去移除的值
                sums -= nums[start];
                hash.remove(nums[start]);
                start++;
            }
            // 此时滑动窗口可以接纳nums[end]
            hash.add(num);
            sums += num;
            largest = Math.max(largest, sums);
        }
        return largest;
    }

    public static void main(String[] args) {
        Solution1695 solution = new Solution1695();
        int[] nums = {5,2,1,2,5,2,1,2,5};
        int i = solution.maximumUniqueSubarray(nums);
        System.out.println("i = " + i);
    }
}
