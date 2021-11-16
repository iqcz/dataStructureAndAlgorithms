package com.lee.datastructureandalgorithms.sort;

/**
 * @author D49450
 */
public class BinarySearch {

    public static void main(String[] args) {
        int [] nums = {-9, 0 ,3, 5, 7, 9, 10};
        System.out.println("binarySearch(nums, 7) = " + binarySearch(nums, 7));
    }
    public static int binarySearch(int [] nums, int target) {
        int length= nums.length;
        int left = 0;
        int right = length -1;
        while (left <= right) {
            int middle = left + (right - left ) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if(nums[middle] > target) {
                right = middle -1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
