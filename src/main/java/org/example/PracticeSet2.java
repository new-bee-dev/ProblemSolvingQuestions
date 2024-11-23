package org.example;

public class PracticeSet2 {
    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        rotateMatrixClockwise(arr);
        // System.out.println(sumOfTwoPrimeNumbers(70));
        //solveTowerOfHanoi(3, 'A', 'C', 'B');
        int[] arr = {1,2,3,46,8,9};
        System.out.println(binarySearch(4, arr));

    }

    /**
     * Implement Binary Search in Java.
     * @param n
     * @param arr
     * @return
     */
    static int binarySearch(int n, int[] arr) {

        int l = arr.length;
        int low = 0;
        int high = l - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == n)
                return mid;
            else if (n > arr[mid]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }

    /**
     * Write a Java program for solving the Tower of Hanoi Problem.
     */
    static void solveTowerOfHanoi(int n, char from_rod, char to_rod, char helper_rod) {

        if (n == 1) {
            System.out.println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        solveTowerOfHanoi(n - 1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        solveTowerOfHanoi(n - 1, helper_rod, to_rod, from_rod);
    }

    /**
     * Write a java program to check if any number given as input is the sum of 2 prime numbers.
     * @return
     */
    static boolean sumOfTwoPrimeNumbers(int n) {

        for (int i = 1; i < n; i ++) {
            if (isPrime(i)) {
                if (isPrime(n - i)) {
                    System.out.println("two prime numbers found: " + i + "," + (n -i));
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        for (int i = 3; i < n; i ++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Write a Java program to rotate arrays 90 degree clockwise by taking matrices from user input.
     * @param arr
     */
    static void rotateMatrixClockwise(int [][] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        // create a transpose matrix
        for (int i = 0; i < n; i ++) {
            for (int j = i; j < arr[i].length; j++) {
                if (i != j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

            // swap first col with last col until middle col is reached.
            for (int i = 0; i < n; i ++) {
                int j = 0; int k = arr[0].length - 1;
                while (j <= k) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[i][k];
                    arr[i][k] = temp;
                    j ++;
                    k --;
                }
            }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < arr[i].length; j++) {
               System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
