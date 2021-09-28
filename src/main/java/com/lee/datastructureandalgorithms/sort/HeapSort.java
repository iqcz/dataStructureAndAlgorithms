package com.lee.datastructureandalgorithms.sort;

import java.util.Arrays;
/**
 * @author i324779
 * zhaoyun
 */
public class HeapSort {
    /**
     * 建一个大顶堆,end表示最多建到的点 log(n)
     */
    public static void maxHeap(int[] data, int start, int end) {
        int parent = start;
        // 下标是从0开始的就要加1，从1就不用
        int son = parent * 2 + 1;
        while (son < end) {
            int temp = son;
            // 比较左右节点和父节点的大小
            // 表示右节点比左节点到
            if (son + 1 < end && data[son] < data[son + 1]) {
                // 就要换右节点跟父节点
                temp = son + 1;
            }
            // temp表示的是 我们左右节点大的那一个
            if (data[parent] > data[temp]) {
                return; // 不用交换
            } else { // 交换
                int t = data[parent];
                data[parent] = data[temp];
                data[temp] = t;
                // 继续堆化
                parent = temp;
                son = parent * 2 + 1;
            }
        }
    }

    public static void heapSort(int[] data) {
        int len = data.length;
        //o(nlgn)
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeap(data, i, len);
        }
        //o(nlgn)
        for (int i = len - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            // len~i已经排好序了
            maxHeap(data, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] data = {8, 4, 20, 7, 3, 1, 25, 14, 17};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }
}
