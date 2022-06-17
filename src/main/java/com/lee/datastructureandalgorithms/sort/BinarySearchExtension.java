package com.lee.datastructureandalgorithms.sort;

/**
 * =二分查找的变体形式
 *
 * @author D49450
 */
public class BinarySearchExtension {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(binarySearch1(nums, 8));
        System.out.println(binarySearch2(nums, 8));
        System.out.println(binarySearch3(nums, 8));
        System.out.println(binarySearch4(nums, 8));
    }

    /**
     * 查找第一个值等于给定值的元算
     *
     * @param nums
     * @param value
     * @return
     */
    public static int binarySearch1(int[] nums, int value) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (nums[mid] > value) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元算
     */
    public static int binarySearch2(int[] nums, int value) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (nums[mid] > value) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                // mid == length - 1 说明已经到了最后
                if (mid == length - 1 || nums[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找第一个值大于或等于给定值的元素
     * @param nums
     * @param value
     * @return
     */
    public static int binarySearch3(int[] nums, int value) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= value) {
                if (mid == 0 || nums[mid -1] < value) {
                    return mid;
                } else {
                    high = mid -1;
                }
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }
    /**
     * 查找最后一个值小于或等于给定值的元素
     * @param nums
     * @param value
     * @return
     */
    public static int binarySearch4(int[] nums, int value) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] <= value) {
                if (mid == length - 1 || nums[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid -1;
            }

        }

        return -1;
    }
}
