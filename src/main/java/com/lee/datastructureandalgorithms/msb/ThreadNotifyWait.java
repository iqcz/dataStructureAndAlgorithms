package com.lee.datastructureandalgorithms.msb;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器，提供两个方法 add，size，写两个线程：
 * 线程1：添加10个元素到容其中
 * 线程2：实时监控元素个数，当个数到5时，线程2给出提示并结束。
 *
 * @author i324779
 */
public class ThreadNotifyWait {
    private volatile List<Integer> list = new ArrayList<>();

    public void add(Integer num) {
        list.add(num);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        ThreadNotifyWait container = new ThreadNotifyWait();
        final Object lock = new Object();

        Runnable target;
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T2 Running...");
                if (container.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t2");

    }
}
