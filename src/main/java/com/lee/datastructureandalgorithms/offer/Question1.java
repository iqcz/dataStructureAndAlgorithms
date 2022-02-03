package com.lee.datastructureandalgorithms.offer;

/**
 * @author Phideon
 */
public class Question1 {

    public int devide(int dividend, int divisor) {
        // 0x8000000 为最小的int类型整数，-2^32; 下面0xc0000000， 是它的一半；
        if (dividend == 0x8000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

        int result = divideCore(dividend, divisor);

        return negative == 1 ? -result : result;
    }

    private int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0x00000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        System.out.println("question1.devide(15, 2) = " + question1.devide(15, 2));
    }
}
