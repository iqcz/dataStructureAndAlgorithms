package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int maxIndex = matrix.length - 1;
        // 先沿着右上到左下的对角线镜像翻转
        for (int x = 0; x <= maxIndex; x++) {
            for (int y = 0; y <= maxIndex - x; y++) {
                int tmp = matrix[x][y];
                matrix[x][y] = matrix[maxIndex - y][maxIndex - x];
                matrix[maxIndex - y][maxIndex - x] = tmp;
            }
        }

        // 再沿着水平中线上下翻转
        for (int i = 0; i <= (maxIndex >> 1); i++) {
            for (int j = 0; j <= maxIndex; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[maxIndex - i][j];
                matrix[maxIndex - i][j] = tmp;
            }
        }
    }
}