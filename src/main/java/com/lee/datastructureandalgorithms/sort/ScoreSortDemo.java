package com.lee.datastructureandalgorithms.sort;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 如何对200万学生的高考成绩（假设成绩最多只有2位小数，0~900范围）进行排序
 * @author i324779
 */
public class ScoreSortDemo {

    public static void sort(double[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int mid = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, mid - 1);
        sort(arr, mid + 1, rightBound);
    }

    static int partition(double[] arr, int leftBound, int rightBound) {
        double pivot = arr[rightBound];
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

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        String str;
        String fileName = "/Users/i324779/Resources/datastructureandalgorithms/src/main/java/com/lee/datastructureandalgorithms/sort/200w.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
        double[] data;
        int i;
        try (BufferedReader br = new BufferedReader(isr)) {
            data = new double[2100002];
            i = 0;
            while ((str = br.readLine()) != null) {
                data[i++] = Double.parseDouble(str);
            }
        }
        System.out.println("Size：" + i);
        long start = System.currentTimeMillis();
        sort(data, 0, data.length - 1);

        File file = new File("/Users/i324779/Resources/datastructureandalgorithms/src/main/java/com/lee/datastructureandalgorithms/sort/200w-qsort.txt");
        try (Writer out = new FileWriter(file)) {
            for (i = 0; i < data.length; i++) {
                out.write(String.valueOf(data[i]) + "\r\n");
            }
        }
        System.out.println("耗时时间:" + (System.currentTimeMillis() - start) + "ms");
    }
}
