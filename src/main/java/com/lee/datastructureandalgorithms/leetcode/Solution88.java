package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @author D49450
 */
public class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0)) {
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1

            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 双指针逆序处理，指向两个数组的最后位置；
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        for (int index = k - 1, nums1Index = m - 1, nums2Index = n - 1; index >= 0; index--) {
            if (nums1Index < 0) {
                nums1[index] = nums2[nums2Index--];
            } else if (nums2Index < 0) {
                break;
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index--];
            } else {
                nums1[index] = nums2[nums2Index--];
            }
        }
    }

    /**
     * 使用临时数组
     *
     * @param nums1 数组1
     * @param m     数组1元素个数
     * @param nums2 数组2
     * @param n     数组2元素个数
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] temp = new int[k];
        for (int index = 0, nums1Index = 0, nums2Index = 0; index < k; index++) {
            if (nums1Index >= m) {
                temp[index] = nums2[nums2Index++];
            } else if (nums2Index >= n) {
                temp[index] = nums1[nums1Index++];
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                temp[index] = nums1[nums1Index++];
            } else {
                temp[index] = nums2[nums2Index++];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        // m = 3
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        // n = 4
        int[] nums2 = {2, 5, 6, 6};

//        merge(nums1, 3, nums2, 4);
//        System.out.println(Arrays.toString(nums1));

//        merge1(nums1, 3, nums2, 4);
//        System.out.println(Arrays.toString(nums1));

        merge2(nums1, 3, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }
}
