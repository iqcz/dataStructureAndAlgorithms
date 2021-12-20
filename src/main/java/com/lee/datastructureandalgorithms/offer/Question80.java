package com.lee.datastructureandalgorithms.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author D49450
 */
public class Question80 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        ;
        helper(n, k, 1, combination, result);
        return result;
    }

    private void helper(int n, int k, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == k) {
            result.add(new LinkedList<>(combination));
        } else if (i <= n) {
            helper(n, k, i + 1, combination, result);
            combination.add(i);
            helper(n, k, i + 1, combination, result);
            combination.removeLast();
        }
    }
}