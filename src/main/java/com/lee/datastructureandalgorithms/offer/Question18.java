package com.lee.datastructureandalgorithms.offer;

public class Question18 {

    public static void main(String[] args) {
        System.out.println("isPalindrome(\"Was it a cat I saw\") = " + isPalindrome("Was it a cat I saw"));
    }
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;

        while(i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!Character.isLetterOrDigit(ch1)) {
                i++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                j--;
            } else {
                ch1 = Character.toUpperCase(ch1);
                ch2 = Character.toUpperCase(ch2);
                if (ch1 != ch2) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
