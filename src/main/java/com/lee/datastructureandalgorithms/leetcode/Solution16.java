package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

/**
 * @author D49450
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        //if (length < 3) return;
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < length - 2; i ++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int s = nums[i] + nums[left] + nums[right];
                if (s == target) {
                    return s;
                }
                if (Math.abs(s - target) < Math.abs(res - target)) {
                    res = s;
                }
                if (s < target) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        return res;
    }
}
