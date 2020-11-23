package com.lee.datastructureandalgorithms.leetcode;

public class PrintNumbers {

    private static final Object lock = new Object();

    private static int counter = 1;

    private static final int MAX_COUNTER = 100;

    public static void main(String[] args) {
        // 奇数打印线程
        Thread oddThread = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (counter <= MAX_COUNTER) {
                        // counter为奇数，打印counter并唤醒偶数打印线程
                        if (counter % 2 != 0) {
                            System.out.println("Thread1 : " + counter);
                            counter = counter + 1;
                            lock.notifyAll();
                        } else {
                            // counter为偶数，挂起并等待偶数打印线程唤醒
                            try {
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        // 偶数打印线程
        Thread evenThread = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (counter <= MAX_COUNTER) {
                        if (counter % 2 == 0) {
                            System.out.println("Thread2 : " + counter);
                            counter = counter + 1;
                            lock.notifyAll();
                        } else {
                            // counter为奇数，挂起并等待奇数打印线程唤醒
                            try {
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        oddThread.start();
        evenThread.start();
    }

}