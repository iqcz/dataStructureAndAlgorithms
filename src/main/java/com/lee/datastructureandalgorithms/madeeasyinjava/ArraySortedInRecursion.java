package com.lee.datastructureandalgorithms.madeeasyinjava;

/**
 * 使用递归方法判断数组中的元素是否是有序的
 *
 * @author i324779
 */
public class ArraySortedInRecursion {

    static int isArrayInSortedOrder(int[] data, int index) {
        if (index == data.length - 1) {
            return 1;
        }
        return data[index] > data[index+1] ? 0 : isArrayInSortedOrder(data, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4 ,5 ,6, 7};
        System.out.println("isArrayInSortedOrder(nums) = " + isArrayInSortedOrder(nums, 0));
    }
}
