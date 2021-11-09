package com.lee.datastructureandalgorithms.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 *
 * 本题其实是排序题目的变种，是一道披着数字外衣的排序题。
 * @author D49450
 */
public class Solution179 {

    public static void main(String[] args) {
        int [] data = {10, 2};
        System.out.println("largestNumber(data) = " + largestNumber(data));
    }

    public static String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        List<String> str = Arrays.asList(s);
        str.sort((String a, String b) -> {
            String left = a + b, right = b + a;
            return right.compareTo(left);
        });
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            ans.append(str.get(i));
        }
        StringBuilder realAns = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < ans.length(); i++) {
            if (!flag) {
                flag = !(ans.charAt(i) == '0');
            }
            if (flag) {
                realAns.append(ans.charAt(i));
            }
        }
        if (!flag) {
            return "0";
        } else {
            return realAns.toString();
        }
    }

}
