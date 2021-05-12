package com.lee.datastructureandalgorithms.zuo.basic;

/**
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，找到这两个数并打印；
 *
 * @author i324779
 */
public class Code0004 {

    public static void printOddTimeNum2(int[] arr) {
        int eor = 0;
        for (int j : arr) {
            eor ^= j;
        }
        // 提取出最右侧的1
        int rightOne = eor & (~eor + 1);
        // eor`;
        int onlyOne = 0;
        for (int j : arr) {
            if ((j & rightOne) != 0) {
                onlyOne ^= j;
            }
        }
        System.out.println(onlyOne + ", " + (onlyOne ^ eor));
    }
}
