package com.lee.datastructureandalgorithms.tuling.leetcode;

/**
 * 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5美元。
 * 顾客排队购买你的产品，一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。必须给每个顾客正确找零
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true，否则返回 false。
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 输入：[10,10]
 * 输出：false
 *
 * @author osyuj
 */
public class Sample20 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println("lemonadeChange(bills) = " + lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}