package com.lee.datastructureandalgorithms.msb;

import java.util.concurrent.CompletableFuture;

/**
 * @author D49450
 */
public class Stock {
    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture
                .supplyAsync(() -> queryCode("中国石油", "https://finance.sina.com.cn/code/"));
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture
                .supplyAsync(() -> queryCode1("中国石油", "https://money.163.com/code/"));

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        cfQuery.thenAccept(result -> {
            System.out.println("price: " + result);
        });

//        // 两个CompletableFuture执行异步查询:
//        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync(code-> {
//            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
//        });
//            CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync(code -> {
//            return fetchPrice((String) code, "https://money.163.com/price/");
//        });
//
//        // 用anyOf合并为一个新的CompletableFuture:
//        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);
//
//        // 最终结果:
//        cfFetch.thenAccept(result -> {
//            System.out.println("price: " + result);
//        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        long time = (long) (Math.random() * 100);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) {
        }
        System.out.println("queryCode:" + time);
        return "601857";
    }

    static String queryCode1(String name, String url) {
        System.out.println("query code1 from " + url + "...");
        long time = (long) (Math.random() * 100);
        try {

            Thread.sleep(time);
        } catch (InterruptedException ignored) {
        }
        System.out.println("queryCode111:" + time);
        return "111111";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException ignored) {
        }
        return 5 + Math.random() * 20;
    }
}
