package com.lee.datastructureandalgorithms.zuo;

import java.util.Arrays;

/**
 * 求数据区间的累加和
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] data = {1, 5, 9, 3, 7, 2};

        Demo02 demo02 = new Demo02();
        int[] preSum = demo02.preSum(data);
        System.out.println(demo02.rangeSum(preSum, 0, 5));
    }

    /**
     * 生成前缀累加和数组
     *
     * @param data
     * @return
     */
    private int[] preSum(int[] data) {
        int[] sum = new int[data.length];
        sum[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            sum[i] = data[i] + sum[i - 1];
        }
        return sum;
    }

    private int rangeSum(int[] data, int left, int right) {
        if (right > data.length) {
            return -1;
        }

        if (left == 0) {
            return data[right];
        }

        return data[right] - data[left - 1];
    }
}
