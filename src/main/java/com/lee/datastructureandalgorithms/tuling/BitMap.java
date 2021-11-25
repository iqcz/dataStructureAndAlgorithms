package com.lee.datastructureandalgorithms.tuling;

/**
 * 如何在2亿个整数中判断某一个数是否存在？
 * 2亿个整数占的内存大小：2亿 * 4 / 1024 / 1024 = 762.9M
 *
 * 内存限制500M，一台机器。
 * @author D49450
 */
public class BitMap {

    /**
     * 如果是byte那就一个只能存8个数
     */
    byte[] bits;
    /**
     * 表示最大的那个数
     */
    int max;

    public BitMap(int max) {
        this.max = max;
        //max/8 + 1
        bits = new byte[(max >> 3) + 1];
    }

    /**
     * 往bitmap里面添加数字
     */
    public void add(int n) {
        // 除以8 就可以知道在那个byte
        int bitsIndex = n >> 3;
        ///这里其实还可以用&运算
        int loc = n % 8;
        //接下来就是要把bit数组里面的 bisIndex这个下标的byte里面的 第loc个bit位置为1
        bits[bitsIndex] |= 1 << loc;
    }

    public boolean find(int n) {
        // 除以8 就可以知道在那个byte
        int bitsIndex = n >> 3;
        ///这里其实还可以用&运算
        int loc = n % 8;
        //如果原来的那个位置是0 那肯定就是0 只有那个位置是1 才行
        int flag = bits[bitsIndex] & (1 << loc);
        return flag != 0;
    }

    public static void main(String[] args) {
        //10亿
        BitMap bitMap = new BitMap(200000000);
        bitMap.add(2);
        bitMap.add(3);
        bitMap.add(65);
        bitMap.add(66);

        System.out.println(bitMap.find(3));
        System.out.println(bitMap.find(64));
    }
}
