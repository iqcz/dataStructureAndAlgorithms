package com.lee.datastructureandalgorithms.yu;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet 一定是无序的吗？
 * 在JDK８以后
 */
public class HashSetDemo {
    public static void main(String[] args) {
        // Integer 是有序的，因为hashcode就是数字本身
        Set<Integer> ints = new HashSet<>();
        ints.add(5);
        ints.add(2);
        ints.add(6);
        ints.add(4);
        // Set 默认长度是16， 如果添加的数字大于16的话，不会有序的。这首需要指定长度
        ints.add(17);
        System.out.println(ints);

        Set<Integer> ints1 = new HashSet<>(32);
        ints1.add(5);
        ints1.add(2);
        ints1.add(17);
        ints1.add(6);
        ints1.add(4);
        // Set 默认长度是16， 如果添加的数字大于16的话，不会有序的。这首需要指定长度
        ints1.add(17);
        System.out.println(ints1);

        Set<Double> dous = new HashSet<>();
        dous.add(5.2);
        dous.add(2.3);
        dous.add(6.0);
        dous.add(4.8);
        System.out.println(dous);

        Set<String> strs = new HashSet<>();
        strs.add("zhangsan");
        strs.add("lisi");
        strs.add("wangwu");
        strs.add("zhaoliu");
        strs.add("liuqi");
        System.out.println(strs);
    }
}