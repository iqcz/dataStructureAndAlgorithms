package com.lee.datastructureandalgorithms.madeeasyinjava;

/**
 * 使用递归方法判断数组中的元素是否是有序的
 *
 * @author i324779
 */
public class ArraySortedInRecursion {

    int isArrayInSortedOrder(int[] data, int index) {
        if (data.length == 1) {
            return 1;
        }
        return data[index - 1] <= data[index - 2] ? 0 : isArrayInSortedOrder(data, index - 1);
    }
}
