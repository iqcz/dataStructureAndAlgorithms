package com.lee.datastructureandalgorithms.offer;

/**
 * @author D49450
 */
public class Question9 {

    public int numSubArrayProductLessThanK(int[] nums, int k) {
        long product = 1L;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            count += right >= left ? right - left + 1 : 0;
        }
        return count;
    }

}