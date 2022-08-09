package com.lee.datastructureandalgorithms.leetcode;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);

        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution165 solution165 = new Solution165();
        System.out.println("solution165.compareVersion(\"1.01.3\", \"1.001\") = " + solution165.compareVersion("1.01.3", "1.001"));
    }
}
