package com.lee.datastructureandalgorithms.leetcode;

/**
 * 整数转罗马数字
 *
 * @author D49450
 */
public class Solution12 {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        return thousands[num / 1000]
                + hundreds[num % 1000 / 100]
                + tens[num % 100 / 10]
                + ones[num % 10];
    }
}
