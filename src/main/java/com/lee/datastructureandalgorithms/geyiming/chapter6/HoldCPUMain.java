package com.lee.datastructureandalgorithms.geyiming.chapter6;

public class HoldCPUMain {

    public static class HoldCPUTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                // 占用CPU
                double a = Math.random() * Math.random();
            }
        }
    }

    public static class LazyTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // 空闲线程
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new HoldCPUTask()).start();
        new Thread((new LazyTask())).start();
        new Thread((new LazyTask())).start();
        new Thread((new LazyTask())).start();
    }
}
