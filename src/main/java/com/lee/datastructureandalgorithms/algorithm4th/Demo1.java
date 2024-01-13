package com.lee.datastructureandalgorithms.algorithm4th;

public class Demo1 {
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }

        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int gcd = gcd(10, 5);
        System.out.println("gcd = " + gcd);
    }

}
