package com.lee.datastructureandalgorithms.sort;

import java.util.Arrays;

/**
 * 好好体会思想，而不是干巴巴地看代码；
 * @author i324779
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        // 校验
        if (arr == null || arr.length == 0) {
            return;
        }

        // 终止条件
        if (left >= right) {
            return;
        }

        // 一分为二，防止越界
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // 分完了，要进行合并
        merge(arr, left, mid, right);

    }

    private static void merge(int[] arr, int left, int middle, int right) {
        // 借助一个临时数组保存合并的数据，要额外申请内存空间
        int[] temp = new int[arr.length];
        // 左边第一个数的位置
        int leftBound = left;
        // 右边第一个数的位置
        int rightBound = middle + 1;
        // 当前已经到的位置
        int loc = left;

        while (leftBound <= middle && rightBound <= right) {
            if (arr[leftBound] < arr[rightBound]) {
                temp[loc++] = arr[leftBound++];
            } else {
                temp[loc++] = arr[rightBound++];
            }
        }

        while (leftBound <= middle) {
            temp[loc++] = arr[leftBound++];
        }

        while (rightBound <= right) {
            temp[loc++] = arr[rightBound++];
        }

        //if (right + 1 - left >= 0) System.arraycopy(temp, left, arr, left, right + 1 - left);
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] data = {7, 5, 6, 8, 2, 9, 1, 3, 4, 0};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}