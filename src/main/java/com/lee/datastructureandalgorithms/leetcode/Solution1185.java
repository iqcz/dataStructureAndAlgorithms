package com.lee.datastructureandalgorithms.leetcode;

import java.time.LocalDate;

/**
 * 一周中的第几天
 *
 * @author D49450
 */
public class Solution1185 {
    static String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        return week[LocalDate.of(year, month, day).getDayOfWeek().getValue() - 1];
    }
}
