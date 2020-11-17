package com.lee.datastructureandalgorithms.yu;

import java.util.HashSet;
import java.util.Set;

/**
 * 在数组1中找到数组2中不存在的字符。
 * @author osyuj
 */
public class FindOne {

    public static char find(char[] chars1, char[] chars2) {
        char oneChar = 0;
        Set<Character> set = new HashSet<>();
        for (char c : chars2) {
            set.add(c);
        }
        for (char c : chars1) {
            if (!set.contains(c)) {
                oneChar = c;
                break;
            }
        }
        return oneChar;
    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'b', 'c', 'd'};
        char[] chars2 = {'a', 'b', 'd'};
        System.out.println(find(chars1, chars2));
    }
}
