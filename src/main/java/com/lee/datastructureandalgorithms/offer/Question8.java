package com.lee.datastructureandalgorithms.offer;

/**
 * @author D49450
 */
public class Question8 {

    public static void main(String[] args) {
        int [] data = {5, 1, 4,3 };
        int result = minSubArrayLen(data, 7);
        System.out.println("result = " + result);
    }

    public static int minSubArrayLen(int[] data, int value) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < data.length; right++) {
            sum += data[right];
            while (right > left && sum >= value) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= data[left];
                left++;
            }
        }
        // 若没有满足条件的
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}