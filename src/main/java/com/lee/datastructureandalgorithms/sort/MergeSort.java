package com.lee.datastructureandalgorithms.sort;

import java.util.Arrays;

/**
 * @author i324779
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // 分完了，要进行合并
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // 借助一个临时数组保存合并的数据
        int[] temp = new int[arr.length];
        // 左边第一个数的位置
        int point1 = left;
        // 右边第一个数的位置
        int point2 = mid + 1;
        // 当前已经到的位置
        int loc = left;

        while (point1 <= mid && point2 <= right) {
            if (arr[point1] < arr[point2]) {
                temp[loc++] = arr[point1++];
            } else {
                temp[loc++] = arr[point2++];
            }
        }
        while (point1 <= mid) {
            temp[loc++] = arr[point1++];
        }

        while (point2 <= right) {
            temp[loc++] = arr[point2++];
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
