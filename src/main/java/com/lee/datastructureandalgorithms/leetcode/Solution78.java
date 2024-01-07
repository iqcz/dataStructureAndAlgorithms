package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author D49450
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        // 解集
        List<List<Integer>> lists = new ArrayList<>();
        // 首先将空集加入解集中
        lists.add(new ArrayList<>());
        for (int num : nums) {
            // 当前子集数
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                // 拷贝所有子集
                List<Integer> newList = new ArrayList<>(lists.get(j));
                // 向拷贝的子集中加入当前数形成新的子集
                newList.add(num);
                // 向lists中加入新子集
                lists.add(newList);
            }
        }
        return lists;
    }
}