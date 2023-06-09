package com.lee.datastructureandalgorithms.sort;

import java.util.Arrays;

/**
 * 两两比较，邻居好说话；
 * @author i324779
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {4, 5, 6, 3, 2, 1};

//        bubbleSort(data);
//        System.out.println(Arrays.toString(data));
        bubbleSortII(data);
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

    public static void bubbleSortII(int [] data) {
        if (data == null || data.length < 2) {
            return;
        };
        for (int end = data.length - 1; end >= 0; end--) {
            for (int start = 1; start <= end; start++) {
                if (data[start - 1] > data[start]) {
                    int temp = data[start - 1];
                    data[start - 1] = data[start];
                    data[start] = temp;
                }
            }
        }
    }
}
