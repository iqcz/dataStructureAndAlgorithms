package com.lee.datastructureandalgorithms.leetcode;

import java.util.Stack;

/**
 * @author i324779
 */
public class Solution394 {
    public static String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            char cur = s.charAt(idx);
            /*处理数字*/
            if (Character.isDigit(cur)) {
                StringBuilder ret = new StringBuilder();
                while (Character.isDigit(s.charAt(idx))) {
                    ret.append(s.charAt(idx++));
                }
                countStack.push(Integer.parseInt(ret.toString()));
            } else if (cur == '[') {
                /*处理“[”*/
                resStack.push(res);
                res = "";
                idx++;
            } else if (cur == ']') {
                /*处理“]”,处理相匹配的“[”之间的字符*/
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                /*处理普通字符*/
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
