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

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int mid = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, mid - 1);
        sort(arr, mid + 1, rightBound);
    }

    static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }

        swap(arr, left, rightBound);

        return left;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
