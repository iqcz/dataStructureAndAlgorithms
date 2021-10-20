package com.lee.datastructureandalgorithms.offer;

import java.util.Arrays;

public class Question6 {

    public static void main(String[] args) {
        int[] data = {1, 2, 4, 6, 10};
        int[] result = twoSum(data, 8);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    public static int[] twoSum(int[] data, int target) {
        int i = 0;
        int j = data.length - 1;
        while (i <= j && data[i] + data[j] != target) {
            if (data[i] + data[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i, j};
    }
}