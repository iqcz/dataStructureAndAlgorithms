package com.lee.datastructureandalgorithms.offer;

/**
 * @author D49450
 */
public class Question4 {
    public static int singleNumber(int[] nums) {
        int[] bitSums = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 100};
        System.out.println("singleNumber(nums) = " + singleNumber(nums));
    }
}
