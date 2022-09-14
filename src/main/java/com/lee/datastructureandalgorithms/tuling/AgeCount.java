package com.lee.datastructureandalgorithms.tuling;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * 一个文件里面包含全国人民（14亿）的年龄数据（0~180），现在要你统计每一个年龄有多少人？
 *
 * @author D49450
 */
public class AgeCount {

    public static void main(String[] args) throws Exception {
//        generateAges();
        String str;
        String fileName = "E:\\age1.txt";
        InputStreamReader isr = new InputStreamReader(Files.newInputStream(Paths.get(fileName)), StandardCharsets.UTF_8);

        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(isr);
        //21亿
        int total = 0;
        //200：年龄范围
        int[] data = new int[200];
        //一行一行的读 O(n)
        while ((str = br.readLine()) != null) {
            int age = Integer.parseInt(str);
            data[age]++;
            total++;
        }
        //O(n) 14亿. 100万/秒 *1000 = 10亿 100~1000s之间 => 500s以下 60*8=480s
        System.out.println("总共的数据大小: " + total);

        //下标从0开始的
        for (int i = 0; i < 200; i++) {
            System.out.println(i + ":" + data[i]);
        }
        //144239ms => 144s
        System.out.println("计算花费的时间为:" + (System.currentTimeMillis() - start) + "ms");
    }

    private static void generateAges() throws IOException {
        final String fileName = "E:\\age1.txt";
        final Random random = new Random();
        BufferedWriter objWriter = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get(fileName))));
        try (objWriter) {
            for (int i = 0; i < 1400000000; i++) {
                int age = Math.abs(random.nextInt()) % 180;
                objWriter.write(age + "\r\n");
            }
            objWriter.flush();
        }
    }
}
