package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author osyuj
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * <p>
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * <p>
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 */
public class Solution867 {
    public static int[][] transpose(int[][] a) {
        int row = a.length;
        int column = a[0].length;
        System.out.println("row = " + row);
        System.out.println("column = " + column);
        // 翻转二位数组的长度
        int[][] transArray = new int[column][row];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                transArray[c][r] = a[r][c];
            }
        }

        return transArray;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transArray = transpose(arr);

        for (int i = 0; i < transArray.length; i++) {
            for (int j = 0; j < transArray[i].length; j++) {
                System.out.print(transArray[i][j]);
            }
            System.out.println();
        }
    }
}
