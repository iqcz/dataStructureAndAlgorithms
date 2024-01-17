package com.lee.datastructureandalgorithms.leetcode;

/**
 * 使用 “快慢指针” 思想，找出循环：“快指针” 每次走两步，“慢指针” 每次走一步，当二者相等时，即为一个循环周期。
 * 此时，判断是不是因为 1 引起的循环，是的话就是快乐数，否则不是快乐数。
 * 注意：此题不建议用集合记录每次的计算结果来判断是否进入循环，因为这个集合可能大到无法存储；
 * 另外，也不建议使用递归，同理，如果递归层次较深，会直接导致调用栈崩溃。
 * 不要因为这个题目给出的整数是 int 型而投机取巧。
 *
 * @author alphayosemite
 */
public class Solution202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    private int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution202 solution = new Solution202();
        System.out.println("solution.isHappy(19) = " + solution.isHappy(19));
    }
}
