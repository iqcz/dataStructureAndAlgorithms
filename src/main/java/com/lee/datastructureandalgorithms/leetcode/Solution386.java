package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序排数
 *
 * @author D49450
 */
public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, list);
        }
        return list;
    }

    private void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(n, i * 10 + j, list);
        }
    }
}
