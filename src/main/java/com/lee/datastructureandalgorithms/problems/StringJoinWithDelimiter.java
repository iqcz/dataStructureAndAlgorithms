package com.lee.datastructureandalgorithms.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author i324779
 */
public class StringJoinWithDelimiter {
    public static String joinByDelimiter(char delimiter, String... args) {
        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }

    public static void main(String[] args) {
        System.out.println("joinByDelimiter('-', \"a\", \"b\") = "
                + joinByDelimiter('-', "a", "b"));
    }
}
