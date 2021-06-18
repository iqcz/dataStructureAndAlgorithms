package com.lee.datastructureandalgorithms.zuo;

/**
 * @author i324779
 */
public class BitMap {

    private final long[] bits;

    public BitMap(int max) {
        bits = new long[(max + 64) >> 6];
    }

    public void add(int num) {
        bits[num >> 6] |= (1L << (num & 63));
    }

    public void delete(int num) {
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }
}

