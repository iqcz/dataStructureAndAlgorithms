package com.lee.datastructureandalgorithms.sort;

public class InsertSort {

    public static void insertSort(int[] a) {
        if (a == null || a.length == 0) {
            throw new RuntimeException("Array is null or empty");
        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    public static void insertSort2(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int data = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > data) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 99, 34, 21, 98};
        insertSort2(a);
        for (int i : a) {
            System.out.printf("%d\t", i);
        }
    }
}



