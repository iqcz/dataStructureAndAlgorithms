package com.lee.datastructureandalgorithms.leetcode;

import java.util.*;

/**
 * 前K个高频单词
 *
 * @author alphayosemite
 */
public class Solution692 {
    /**
     * 哈希表 + 排序
     * 统计每一个单词出现的频率，然后依据每个单词出现的频率降序排序，最后返回前 k 个字符串即可。
     * 排序时，如果两个字符串出现频率相同，那么我们让两字符串中字典序较小的排在前面，
     * 否则让出现频率较高地排在前面。只需要保留序列中的前 k 个字符串即可。
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        List<String> rec = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        rec.sort((word1, word2) ->
                Objects.equals(cnt.get(word1), cnt.get(word2)) ?
                        word1.compareTo(word2) :
                        cnt.get(word2) - cnt.get(word1)
        );
        return rec.subList(0, k);
    }

    public static void main(String[] args) {
        String [] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println("topKFrequent(words) = " + topKFrequent(words, 2));
    }
}
