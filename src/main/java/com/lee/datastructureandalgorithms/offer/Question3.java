package com.lee.datastructureandalgorithms.offer;

import java.util.Arrays;

/**
 * 前 n 个数字二进制形式中1的个数
 *
 * @author D49450
 */
public class Question3 {

    public static int[] countBits(int num) {
        // num + 1：多一个0；
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                // 计算i的二进制形式中1的个数
                // 记住了就行，该记忆就要记忆
                j = j & (j - 1);
            }
        }
        return result;
    }

    public static int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = countBits(4);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
        int[] result1 = countBits2(4);
        System.out.println("Arrays.toString(result1) = " + Arrays.toString(result1));
    }
}