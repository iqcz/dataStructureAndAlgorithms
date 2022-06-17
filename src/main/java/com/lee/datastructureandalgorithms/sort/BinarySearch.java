package com.lee.datastructureandalgorithms.sort;

/**
 * @author D49450
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-9, 0, 3, 5, 7, 9, 10};
        System.out.println("binarySearch(nums, 7) = " + binarySearch(nums, 7));
        System.out.println("binarySearch1(nums, 5) = " + binarySearch1(nums, 6));
        System.out.println("binarySearch2(nums, 2) = " + binarySearch2(nums, 2));

        System.out.println("bSearch(nums, nums.length, 7) = " + bSearch(nums, nums.length, 7));
    }

    public static int binarySearch(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 在有序数组中查找第一个大于或等于target的元素，且该元素一定存在。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        int left = 0;
        int high = nums.length - 1;
        while (left <= high) {
            int middle = left + ((high - left) >> 1);

            if (left == high) {
                break;
            } else if (nums[middle] >= target) {
                high = middle;
            } else {
                left = middle + 1;
            }
        }
        return nums[left];
    }

    /**
     * 在有序数组中查找最后一个小于或等于target的元素，且该元素一定存在
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int high = nums.length - 1;
        while (left <= high) {
            int middle = left + ((high - left) >> 1);
            if (left == high || left + 1 == high) {
                break;
            } else if (nums[middle] <= target) {
                left = middle;
            } else {
                high = middle - 1;
            }
        }
        if (nums[high] <= target) {
            return nums[high];
        } else {
            return nums[left];
        }
    }

    public static int bSearch(int[] nums, int length, int values) {
        return bSearchInternally(nums, 0, length - 1, values);
    }

    /**
     * 递归
     * @param nums 待查询的数组
     * @param low 下限
     * @param high 上限
     * @param value 待查找的数字
     * @return
     */
    private static int bSearchInternally(int[] nums, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == value) {
            return mid;
        } else if (nums[mid] < value) {
            return bSearchInternally(nums, mid + 1, high, value);
        } else {
            return bSearchInternally(nums, 0, mid - 1, value);
        }
    }
}