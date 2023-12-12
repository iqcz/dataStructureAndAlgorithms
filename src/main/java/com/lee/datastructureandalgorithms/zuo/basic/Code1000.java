package com.lee.datastructureandalgorithms.zuo.basic;

/**
 * 整数的二进制表示
 * @author D49450
 */
public class Code1000 {
    public static String int2Binary(int value) {
        StringBuilder sb = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            sb.append((value & (1 << i)) == 0 ? "0" : "1");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(int2Binary(Integer.MAX_VALUE));
    }
}
