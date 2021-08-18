package com.lee.datastructureandalgorithms.problems;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author osyuj
 */
public class StringLengthSort {
    public static void main(String[] args) {
        String[] strs = {"hello", "world", "xiaojun"};
        String[] sortedStrs = sortArrayByLength(strs, "asc");
        System.out.println(Arrays.toString(sortedStrs));
    }

    public static String[] sortArrayByLength(String[] strs, String directions) {
        if (directions.equalsIgnoreCase("asc")) {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
        } else {
            return Arrays.stream(strs).
                    sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);

        }
    }
}
