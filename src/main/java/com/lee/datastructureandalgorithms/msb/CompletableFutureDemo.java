package com.lee.datastructureandalgorithms.msb;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author i324779
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start;
        long end;
        start = System.currentTimeMillis();

        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(() -> priceOfTm());
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(() -> priceOfTb());
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(() -> priceOfJd());

        CompletableFuture.allOf(futureTM, futureTB, futureJD).join();

//        CompletableFuture.supplyAsync(() -> priceOfTm())
//                .thenApply(String::valueOf)
//                .thenApply(str -> "price " + str)
//                .thenAccept(System.out::println);


        end = System.currentTimeMillis();
        System.out.println("use completable future! " + (end - start));

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double priceOfTm() {
        delay();
        return 1.00;
    }

    private static double priceOfTb() {
        delay();
        return 2.00;
    }

    private static double priceOfJd() {
        delay();
        return 3.00;
    }

    private static void delay() {
        int time = new Random().nextInt(500);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("After %s sleep!\n", time);
    }
}
