package com.lee.datastructureandalgorithms.offer;

import java.util.Arrays;

public class Question3 {

    public static int[] countBits(int num) {
        // num + 1：多一个0；
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result  = countBits(4);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}