package com.lee.datastructureandalgorithms.zuo.basic;

/**
 * 使用二分法处理局部最小值问题
 */
public class Code0001 {

    public static int getLessIndex(int[] arr) {
        // 不存在
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int middle = 0;
        while (left < right) {
            middle = (left + right) / 2;
            if (arr[middle] > arr[middle - 1]) {
                right = middle - 1;
            } else if (arr[middle] > arr[middle + 1]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return middle;
    }
}
