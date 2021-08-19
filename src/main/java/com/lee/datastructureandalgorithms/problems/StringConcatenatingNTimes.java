package com.lee.datastructureandalgorithms.problems;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Concatenating the same string n times
 * @author osyuj
 */
public class StringConcatenatingNTimes {

    public static final String TEXT = "Hello";

    public static void main(String[] args) {
        String result = Stream.generate(() -> TEXT)
                .limit(5)
                .collect(Collectors.joining());

        System.out.println("result = " + result);

        String result1 = String.join("", Collections.nCopies(5, TEXT));
        System.out.println("result1 = " + result1);
    }


}
