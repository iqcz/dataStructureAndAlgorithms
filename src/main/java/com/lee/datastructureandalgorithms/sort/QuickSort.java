package com.lee.datastructureandalgorithms.sort;

import java.util.Arrays;

/**
 * @author i324779
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 99, 34, 21, 98};
        quickSort(a);

        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数组内的元素进行排序
     *
     * @param a
     */
    public static void quickSort(int[] a) {
        int low = 0;
        int high = a.length - 1;
        sort(a, low, high);
    }

    /**
     * 对数组a中从索引lo到索引hi之间的元素进行排序
     *
     * @param a
     * @param low
     * @param high
     */
    private static void sort(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        // 需要对数组中low索引到high索引处的元素进行分组(左子组和右子组)
        // 返回的是分组的分界值所在的索引，分界值位置变换后的索引
        int partition = partition(a, low, high);

        // 左子组排序
        sort(a, low, partition - 1);
        //右子组排序
        sort(a, partition + 1, high);
    }

    /**
     * 对数组a中，从索引low到索引high之间的元素进行分组，并返回分组界限对应的索引
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] a, int low, int high) {
        // 确定分界值
        int pivot = a[low];
        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = low;
        int right = high + 1;
        // 切分
        while (true) {
            // 先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (pivot < a[--right]) {
                if (right == low) {
                    break;
                }
            }

            // 再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (a[++left] < pivot) {
                if (left == high) {
                    break;
                }
            }
            // 判断 left>=right,如果是，则证明元素扫描完毕，结束循环，如果不是，则交换元素即可
            if (left >= right) {
                break;
            } else {
                swap(a, left, right);
            }
        }
        // 交换分界值
        swap(a, low, right);

        return right;
    }

    /**
     * 数组元素交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}