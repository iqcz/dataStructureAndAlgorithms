package com.lee.datastructureandalgorithms.sort;

/**
 * 抓扑克牌
 * @author D49450
 */
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
   /* public static void insertSort3(int[] a) {
        for (int end = 1; end < a.length; end++) {
            int newNumberIndex = end;
            while (newNumberIndex - 1 >= 0 && a[newNumberIndex - 1] > a[newNumberIndex]) {
                swap(a, newNumberIndex - 1, new); newNumberIndex--;
            }
        }
    }*/

   /* public static void insertSort4(int[] a) {
        for (int end = 1; end < a.length; end++) {
        // pre：新数的前一个位置
            for (int pre = end - 1; pre >= 0 && a[pre] > a[pre + 1]; pre--) {
                swap(a, pre, pre + 1);
            }
        }
    }*/

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 99, 34, 21, 98};
        insertSort2(a);
        for (int i : a) {
            System.out.printf("%d\t", i);
        }
    }
}



