package com.lee.datastructureandalgorithms.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author D49450
 */
public class Solution53 {
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static int maxSubArray1(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    // 分治法
    /**
     * 动态规划
     */
    public static int maxSubArrayDp(int[] nums) {
        int result = nums[0];
        int pre = result;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            if (pre > result) {
                result = pre;
            }
        }
        return result;
    }
    // 前缀和


    public static void main(String[] args) {
        int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(data));
        System.out.println(maxSubArray1(data));
        System.out.println(maxSubArrayDp(data));
    }
}
