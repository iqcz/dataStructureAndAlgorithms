package com.lee.datastructureandalgorithms.tuling;

/**
 * @author i324779
 */
public class Fibonacci {

    private static int[] data;

    /**
     * 斐波那契数列
     * 1 1 2 3 5 8 13
     * f(n)=f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */
    public static int fab(int n) { // 分析一段代码好坏，有两个指标，时间复杂度和空间复杂度 都是：O(2^n)
        // 递归的终止条件
        if (n <= 2) {
            return 1;
        }
        // 继续递归的过程
        return fab(n - 1) + fab(n - 2);
    }

    /**
     * 求N的阶乘 用普通递归怎么写 5=5*4*3*2*1=> f(n) =
     *
     * @param n
     * @return
     */
    public static int fac(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fac(n - 1);
    }

    public static int noFab(int n) { // 不用递归 O(n)
        // 循环
        if (n <= 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 用数组来做缓存 将为了O(n)，空间也降至为O(n)
     *
     * @param n
     * @return
     */
    public static int fab2(int n) {
        // 递归的终止条件
        if (n <= 2) {
            return 1;
        }
        if (data[n] > 0) {
            return data[n];
        }
        // 继续递归的过程
        int res = fab2(n - 1) + fab2(n - 2);
        data[n] = res;
        return res;
    }

    /**
     * 使用尾递归计算斐波那契数列
     * 分析一段代码好坏，有两个指标，时间复杂度和空间复杂度 都是： O(n)
     *
     * @param pre 上上一次运算出来的结果
     * @param res 上一次运算出来结果
     * @param n
     * @return
     */
    public static int tailFab(int pre, int res, int n) {
        // 递归的终止条件
        if (n <= 2) {
            return res;
        }
        return tailFab(res, pre + res, n - 1);
    }

    /**
     * 尾递归 传结果，res就是我们每次保存的结果
     *
     * @param n
     * @param res
     * @return
     */
    public static int tailFac(int n, int res) {
        // 这个地方打印出来的值是怎么样的？
        System.out.println(n + ":" + res);
        if (n <= 1) {
            return res;
        }
        // 倒着算
        return tailFac(n - 1, n * res);
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 45; i++) {
            long start = System.currentTimeMillis();
            System.out.println(i + ":" + tailFab(1, 1, i) + " 所花费的时间为" + (System.currentTimeMillis() - start) + "ms");
        }
        //tailFac(5, 1);

        /*
         * for (int i = 1; i <= 45; i++) { long start =
         * System.currentTimeMillis(); System.out.println(i + ":" + fab(i) +
         * " 所花费的时间为" + (System.currentTimeMillis() - start) + "ms"); }
         */

        for (int i = 1; i <= 45; i++) {
            long start = System.currentTimeMillis();
            System.out.println(i + ":" + noFab(i) + " 所花费的时间为" + (System.currentTimeMillis() - start) + "ms");
        }
        System.out.println("==================================");
        System.out.println("加了缓存的情况");
        for (int i = 1; i <= 45; i++) {
            data = new int[46];
            long start = System.currentTimeMillis();
            System.out.println(i + ":" + fab2(i) + " 所花费的时间为" + (System.currentTimeMillis() - start) + "ms");
        }
    }

}
