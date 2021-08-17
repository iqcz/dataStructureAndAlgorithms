package com.lee.datastructureandalgorithms.problems;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
 * @author i324779
 */
public class CharacterMostAppearances {
    public static void main(String[] args) {
        System.out.println(maxOccurenceCharacter("abbccdddd"));
    }

    public static Map.Entry<Character, Long> maxOccurenceCharacter(String str) {
        return str.chars()
                .filter(c -> !Character.isWhitespace(c))
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .get();
    }

}
