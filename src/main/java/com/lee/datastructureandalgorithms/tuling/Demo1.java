package com.lee.datastructureandalgorithms.tuling;

/**
 * 判断一个数是否是2的n次方
 *
 * @author osyuj
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(isTrue(7));
    }

    private static boolean isTrue(int n) {
        return (n & (n - 1)) == 0;
    }
}
