package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 * @author D49450
 */
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            // 对n取模还原出它本来的值
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 也可以使用 hashmap ，但需要额外分配空间
     */

    public static void main(String[] args) {
        int [] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution448 solution448 = new Solution448();
        System.out.println("solution448.findDisappearedNumbers(nums) = "
                + solution448.findDisappearedNumbers(nums));
    }
}
