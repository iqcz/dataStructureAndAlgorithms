package com.lee.datastructureandalgorithms.zuo;

/**
 * 有序数组中找到 >= num 最左的位置（index））
 */
public class Demo03 {
    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        int[] data = {1, 2, 2, 2, 4, 5, 6, 7};
        System.out.println("demo03.findMostLeftNoLessThanNumIndex(data, 2) = "
                + demo03.findMostLeftNoLessThanNumIndex(data, 3));
    }

    private int findMostLeftNoLessThanNumIndex(int[] data, int num) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int left = 0;
        int right = data.length - 1;
        // 记录满足要求最左下标位置
        int index = -1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (data[middle] >= num) {
                index = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return index;
    }
}

