package com.lee.datastructureandalgorithms.offer;

/**
 * @author D49450
 */
public class Question18 {

    public static void main(String[] args) {
        String str = "Was it a cat I saw";
        System.out.println("isPalindrome(\"Was it a cat I saw\") = " + isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);
            if (!Character.isLetterOrDigit(ch1)) {
                left++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                right--;
            } else {
                ch1 = Character.toUpperCase(ch1);
                ch2 = Character.toUpperCase(ch2);
                if (ch1 != ch2) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
