package com.lee.datastructureandalgorithms.leetcode;

import java.time.LocalDate;

/**
 * 一年中的第几天
 *
 * @author D49450
 */
public class Solution1154 {
    public int dayOfYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate.getDayOfYear();
    }
}
