package com.lee.datastructureandalgorithms.leetcode;

public class Solution415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        // 进位
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        for (; i >= 0 || j >= 0 || carry == 1; i--, j--) {

            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
