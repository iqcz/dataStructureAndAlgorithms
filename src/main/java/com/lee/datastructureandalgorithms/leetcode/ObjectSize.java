package com.lee.datastructureandalgorithms.leetcode;

//import org.openjdk.jol.info.ClassLayout;

public class ObjectSize {
//    public static void main(String[] args) {
//        System.out.println("对象内存");
//        ClassLayout layout = ClassLayout.parseInstance(new Object());
//        System.out.println(layout.toPrintable());
//
//        System.out.println("数组内存");
//        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
//        System.out.println(layout1.toPrintable());
//
//        System.out.println("MyObject对象内存");
//        ClassLayout layout2 = ClassLayout.parseInstance(new MyObject());
//        System.out.println(layout2.toPrintable());
//    }

    /**
     * ‐XX:+UseCompressedOops 默认开启的压缩所有指针
     * ‐XX:+UseCompressedClassPointers 默认开启的压缩对象头里的类型指针Klass Pointer
     * Oops : Ordinary Object Pointers

    public static class MyObject {
        //8B mark word
        //4B Klass Pointer 如果关闭压缩‐XX:‐UseCompressedClassPointers或‐XX:‐UseCompressedOops，则占用8B
        int id; //4B
        String name; //4B 如果关闭压缩‐XX:‐UseCompressedOops，则占用8B
        byte b; //1B
        Object o; //4B 如果关闭压缩‐XX:‐UseCompressedOops，则占用8B
    }
     */
}