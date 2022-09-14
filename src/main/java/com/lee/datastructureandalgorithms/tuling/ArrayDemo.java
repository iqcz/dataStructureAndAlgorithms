package com.lee.datastructureandalgorithms.tuling;

public class ArrayDemo {
    private final int[] data;
    private final int size;
    private int index; // 当前已经存储的数据长度

    public ArrayDemo(int size) {
        this.size = size;
        data = new int[size];
        this.index = 0;
    }

    public void print() {
        for (int value : data) {
            System.out.println("value = " + value);
        }
    }

    /**
     * 新增元素
     *
     * @param location 插入下标位置
     * @param value    待插入元素
     */
    public void insert(int location, int value) {
        if (index++ < size) {
            for (int i = size - 1; i > location; i--) {
                // 从后面插入，数据后移
                data[i] = data[i - 1];
            }
            data[location] = value;
        }
        //  todo 扩容
    }

    /**
     * 删除元素
     *
     * @param location 待删除元素下标
     */
    public void delete(int location) {
        for (int i = location; i < size; i++) {
            if (i != size - 1) {
                data[i] = data[i + 1];
            } else {
                data[i] = 0;
            }
        }
        index--;
    }

    public void update(int location, int value) {
        data[location] = value;
    }

    public int get(int location) {
        return data[location];
    }
}
