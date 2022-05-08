package com.lee.datastructureandalgorithms.msb;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorSample {

    private static final int QUEUE_SIZE = 100;

    public static void main(String[] args) {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(4, 20, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(QUEUE_SIZE));

        List<String> names = Lists.newArrayList("1", "2", "3", "4", "5" ,"6" , "7","8", "9", "10" ,"11", "12", "13"
        , "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        List<List<String>> partition = Lists.partition(names, 3);
//        System.out.println("partition = " + partition);
        partition.forEach(partNames -> tp.execute(() -> System.out.println("partNames = " + partNames)));

        tp.shutdown();
        try {
            tp.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
