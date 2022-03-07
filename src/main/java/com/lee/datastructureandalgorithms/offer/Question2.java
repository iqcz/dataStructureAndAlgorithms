package com.lee.datastructureandalgorithms.offer;

/**
 * @author Phideon
 * 将两个数字的右端对齐，然后从它们的个位开始从右向左相加同一位置的两个数位；
 * 如果前一位有进位还要加上进位；
 */
public class Question2 {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 进位
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Question2 question2 = new Question2();
        System.out.println("question2.addBinary(\"10\", \"11\") = " + question2.addBinary("10", "11"));
    }
}
