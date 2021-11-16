package com.lee.datastructureandalgorithms.sort;


import java.util.Arrays;

/**
 * @author i324779
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 0, 8, 7, 3, 6, 5, 9};
        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int leftBound = left;
        int rightBound = right - 1;

        while (leftBound <= rightBound) {
            while (leftBound <= rightBound && arr[leftBound] <= pivot) {
                leftBound++;
            }
            while (leftBound <= rightBound && arr[rightBound] > pivot) {
                rightBound--;
            }

            if (leftBound < rightBound) {
                swap(arr, leftBound, rightBound);
            }
        }

        swap(arr, leftBound, right);

        return leftBound;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}