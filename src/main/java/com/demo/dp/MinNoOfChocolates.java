package com.demo.dp;

public class MinNoOfChocolates {

    /**
     * Miss. Noor Rashid is a teacher.
     * She wants to give some chocolates to the students in her class.
     * All the students sit in a line, and each of them has a score according to performance.
     * Noor wants to give at least one chocolate to each student.
     * She distributes chocolates to them such that If two students sit next to each other,
     * then the one with the higher score must get more chocolates.
     * Miss. Noor wants to save money, so she wants to minimize the total number of chocolates.
     */
    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 1, 5, 4, 6, 7};
        System.out.println(getMin(arr, arr.length));
    }

    /**
     * Find no of chocolates LTR and RTL & find sum of max of two
     */
    public static int getMin(int arr[], int n) {

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];

        for (int i = 0; i < n; i++) {
            // Left to Right
            if (i > 0 && arr[i] > arr[i - 1]) {
                memo1[i] = memo1[i - 1] + 1;
            } else {
                memo1[i] = 1;
            }

            // Right to Left
            int ii = n - i - 1;
            if (ii + 1 < n && arr[ii] > arr[ii + 1]) {
                memo2[ii] = memo2[ii + 1] + 1;
            } else {
                memo2[ii] = 1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.max(memo1[i], memo2[i]);
        }

        return res;
    }
}