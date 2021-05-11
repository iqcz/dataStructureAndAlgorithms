package com.lee.datastructureandalgorithms.zuo.basic;

/**
 * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，找到并打印
 * @author i324779
 */
public class Code0002 {

    public static int getOddNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return  -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int eor = 0;
        for (int j : arr) {
            eor ^= j;
        }
        return eor;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 4, 3, 2, 3, 4, 2, 7};
        System.out.println("getOddNumber(arr) = " + getOddNumber(arr));
    }
}
