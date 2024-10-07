package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D49450
 * <p>
 * Z 字形变换
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().convert("PAYPALISHIRING", 3));
    }
}
