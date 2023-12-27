package com.lee.datastructureandalgorithms.leetcode;

/**
 * 统计位数为偶数的数字个数
 *
 * @author D49450
 */
public class Solution1295 {
    public int findNumbers(int[] nums) {
        int rtn = 0;
        for (int num : nums) {
            int count = 0;
            while (num != 0) {
                num /= 10;
                count++;
            }

            rtn = count % 2 == 0 ? ++rtn : rtn;
        }
        return rtn;
    }

    public static void main(String[] args) {
        Solution1295 solution = new Solution1295();

        int[] nums = {12, 345, 2, 6, 7896};
        int numbers = solution.findNumbers(nums);
        System.out.println("numbers = " + numbers);
    }

}
