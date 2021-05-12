package com.lee.datastructureandalgorithms.zuo.basic;

/**
 * 提取一个 int 的二进制中1的个数
 *
 * @author i324779
 */
public class Code0005 {

    public static int countBit1(int number) {
        int count = 0;
        while (number != 0) {
            int rightOne = number & ((~number) + 1);
            count++;
            number ^= rightOne;
        }
        return count;
    }
}
