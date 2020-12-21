package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;

/**
 * @author osyuj
 */
public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] oldArr = Arrays.copyOf(arr, arr.length);
        System.out.println("Arrays.toString(oldArr) = " + Arrays.toString(oldArr));
        int[] sortedArr = new int[arr.length];
        Arrays.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        // 去重
        removeDuplicates(arr);

        for (int i = 1; i <= oldArr.length; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (oldArr[i - 1] == arr[j - 1]) {
                    sortedArr[i - 1] = j;
                    break;
                }
            }
        }
        System.out.println("Arrays.toString(sortedArr) = " + Arrays.toString(sortedArr));
        return sortedArr;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        Solution1331 solution1331 = new Solution1331();
//        int[] arr = {40, 10, 20 ,30};
//        int[] arr = {100, 100, 100};
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        solution1331.arrayRankTransform(arr);
        for (int i = 1; i <= arr.length; i++) {
            System.out.print(arr[i - 1] + ",");
        }
    }
}
