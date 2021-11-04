package com.lee.datastructureandalgorithms.zen;

public class Zen01 {

    public static void main(String[] args) {
        int [] data = {1, 2 ,3 ,4, 5};
        System.out.println("sum(data) = " + sum(data));
        System.out.println("sumToEnd(data, 0) = " + sumToEnd(data, 0));
    }

    /**
     * 递推（recurrence）
     *
     * @param data
     * @return
     */
    public static int sum(int[] data) {
        int sum = 0;
        for (int d : data) {
            sum += d;
        }

        return sum;
    }

    /**
     * 递归（recursion）
     *
     * @param data
     * @return
     */
    public static int sumToEnd(int[] data, int cur) {
//        if (cur == data.length - 1) {
//            return data[cur];
//        }
        // 上面的if判断可以换成下面的逻辑；
        // 更短小，更犀利，使用了“越界代偿”的技巧；
        // 越界代偿：就是用一个“无害”的值取取代或补偿一个“无意义”，甚至“有害”的值。
        if (cur == data.length) {
            return 0;
        }
        return data[cur] + sumToEnd(data, cur + 1);
    }
}
