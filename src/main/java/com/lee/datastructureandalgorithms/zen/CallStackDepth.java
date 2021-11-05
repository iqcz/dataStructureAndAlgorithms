package com.lee.datastructureandalgorithms.zen;

/**
 * 模拟StackOverflowError
 * @author D49450
 */
public class CallStackDepth {
    public static void main(String[] args) {
        goDeeper(2);
    }

    public static void goDeeper(int level) {
        // 刻意移除停止机制
        if (level == 10000) {
            return;
        }
        System.out.println("level = " + level);
        goDeeper(level +1);
    }
}
