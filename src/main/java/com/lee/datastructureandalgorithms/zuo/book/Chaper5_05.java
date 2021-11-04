package com.lee.datastructureandalgorithms.zuo.book;

/**
 * @author D49450
 * 判断字符数组中是否所有的字符都只出现过一次
 */
public class Chaper5_05 {

    public static boolean isUniqueI(char[] chars) {
        if (chars == null || chars.length == 0) {
            return false;
        }

        boolean[] map = new boolean[256];
        for (char value : chars) {
            if (map[value]) {
                return false;
            }
            map[value] = true;
        }
        return true;
    }

    public static boolean isUniqueII(char[] chars) {
        return true;
    }

    public static void main(String[] args) {
//        char[] chars = {'a', 'b', 'c', 'd', 'a'};
        char[] chars = {'1', '2', '3', '4'};
        System.out.println("isUniqueI(chars) = " + isUniqueI(chars));
        System.out.println("isUniqueII(chars) = " + isUniqueII(chars));
    }
}
