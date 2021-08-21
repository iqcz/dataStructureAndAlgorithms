package com.lee.datastructureandalgorithms.problems;

import java.util.Objects;

public class NullProblems {
    public static void main(String[] args) {
        String name = Objects.requireNonNullElse(null, "default name");
        System.out.println("name = " + name);

        Objects.requireNonNull(null, "Name can not be null");

    }
}