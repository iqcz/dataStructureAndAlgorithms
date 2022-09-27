package com.lee.datastructureandalgorithms.msb;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * D49450
 */
public class ThreadCPUDemo {
    private static final int COUNT = 1_00_000_000;

    private static final double[] nums = new double[COUNT];

    private static Random random = new Random();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextDouble();
        }
    }

    private static void m1() {
        long start = System.currentTimeMillis();
        double result = 0D;
        for (double num : nums) {
            result += num;
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start) + ", 结果：" + df.format(result));
    }

    private static void method() throws InterruptedException {
        final int threadCount = 6;
        Thread[] threads = new Thread[threadCount];
        double[] results = new double[threadCount];
        final int segmentCount = nums.length / threadCount;
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            int m = i;
            threads[i] = new Thread(() -> {
                for (int j = m * segmentCount; j < (m + 1) * segmentCount && j < nums.length; j++) {
                    results[m] += nums[j];
                }
                latch.countDown();
            });
        }

        double result = 0D;

        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }

        latch.await();
        for (double v : results) {
            result += v;
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start) + ", 结果：" + df.format(result));
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
        m1();
        method();
    }
}
