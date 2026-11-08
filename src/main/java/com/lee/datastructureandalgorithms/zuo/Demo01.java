package com.lee.datastructureandalgorithms.zuo;

/**
 * 整数转二进制
 */
public class Demo01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        System.out.println(demo01.convertBinary(5));
    }

    public String convertBinary(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            result.append((num & (1 << i)) == 0 ? "0" : "1");
        }
        return result.toString();
    }
}
