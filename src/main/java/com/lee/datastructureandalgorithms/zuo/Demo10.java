package com.lee.datastructureandalgorithms.zuo;

/**
 * 在数组指定范围内查找最大值
 * 使用递归
 *
 * @author i324779
 */
public class Demo10 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 9, 1, 4, 7};
        System.out.println(maxInRange(arr, 4, 6));
    }

    public static int maxInRange(int[] arr, int left, int right) {
        return process(arr, left, right);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
//        int middle = left + (right - left) / 2;
        int middle = left + ((right - left) >> 1);
        int leftValue = process(arr, left, middle);
        int rightValue = process(arr, middle + 1, right);
        return Math.max(leftValue, rightValue);
    }
}
