package org.example;

import java.util.Arrays;

public class PracticeSet1 {

    public static void main(String[] args) {

        // printFibonacciSeries(10);
        // System.out.println(checkIfAnagramStrings("abcd", "dcba"));
        // System.out.println(fact(5));
//        int [] arr = {1,2,3,5};
//        System.out.println(findMissingNumber(arr, 5));
        System.out.println(isNumberMagic(192));
    }

    /**
     * Write a Java Program to check if any number is a magic number or not.
     * A number is said to be a magic number if after doing the sum of digits in each step and in turn doing the sum of digits of that sum,
     * the ultimate result (when there is only one digit left) is 1.
     * @param n
     * @return
     */
    static boolean isNumberMagic(int n) {

        int sum = 0;

        while (n >= 9) {
            while(n > 0) {
                sum = sum + (n % 10);
                n = n / 10;
            }
            n = sum;
            sum = 0;
        }
        return n == 1;
    }
    /**
     * Given an array of non-duplicating numbers from 1 to n where one number is missing,
     * write an efficient java program to find that missing number.
     * @param arr
     * @param n
     * @return
     */
    static int findMissingNumber(int[] arr, int n) {

        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < arr.length; i ++) {
            xor1 ^= arr[i];
        }
        for (int i = 1; i <= n; i ++) {
            xor2 ^= i;
        }
        return xor1 ^ xor2;
    }

    /**
     * Write a Java Program to find the factorial of a given number.
     * @param n
     * @return
     */
    static int fact(int n) {

        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }
    /**
     * Write a Java Program to print Fibonacci Series using Recursion.
     *
     * @param n
     */
    static void printFibonacciSeries(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(fabHelper(i));
        }
    }

    private static int fabHelper(int n) {

        if (n == 1 || n == 0) {
            return 1;
        }
        return fabHelper(n - 1) + fabHelper(n - 2);
    }

    /**
     * Write a Java program to check if the two strings are anagrams.
     * An anagram of a string is another string that contains the same characters,
     * only the order of characters can be different.
     * @param s1
     * @param s2
     */
    static boolean checkIfAnagramStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i ++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
