package com.lee.datastructureandalgorithms.sort;

/**
 * @author i324779
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 99, 34, 21, 98};
        shellSort(a);
        for (int i : a) {
            System.out.printf("%d\t", i);
        }
    }

    public static void shellSort(int[] a) {
        // 确定增量的初始值
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j - h] > a[j]) {
                        // 交换元素
                        int tmp = a[j - h];
                        a[j - h] = a[j];
                        a[j] = tmp;
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
        }
    }

    public static void shellSort2(int[] arr) {
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
