package com.lee.datastructureandalgorithms.sort;

import java.util.Arrays;

/**
 * @author i324779
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {4, 5, 6, 3, 2, 1};

        bubbleSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void bubbleSort(int[] data) {
        int length = data.length;
        //排序的次数
        for (int i = 0; i < length - 1; i++) {
            // 是否发生交换
            boolean flag = false;
            // length - 1 - i：后面已经有i个确定的排好序的元素了。
            for (int j = 0; j < length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
