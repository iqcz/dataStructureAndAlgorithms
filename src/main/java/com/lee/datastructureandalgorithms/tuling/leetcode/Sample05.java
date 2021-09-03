package com.lee.datastructureandalgorithms.tuling.leetcode;


/**
 * 删除排序数组中的重复项，返回删除后元素个数
 * 一个有序数组 nums ，原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长
 * 度。
 * 不要使用额外的数组空间，必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 使用双指针算法
 *
 * @author osyuj
 */
public class Sample05 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 4, 5};
        System.out.println("removeDuplicates(nums) = " + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
