package com.demo.dp;

import java.util.Arrays;

public class SubsetSumEqualToKPresent {

    /**
     * You are given a set of N integers.
     * You have to return true if there exists a subset that sum up to K, otherwise return false.
     */
    public static void main(String[] args) {
        System.out.println(isSubsetPresentRecursive(new int[] {4, 2, 5, 6, 7}, 14));
        System.out.println(isSubsetPresentIterative(new int[] {4, 2, 5, 6, 7}, 14));
    }

    static boolean isSubsetPresentIterative(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum + 1];

        for (int[] a: dp) {
            Arrays.fill(a, -1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for(int s = 0; s <= sum; s++) {
                dp[i][s] = exists(arr, i, s, dp) ? 1 : 0;
                if (s == sum && dp[i][s] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean exists(int[] arr, int i, int sum, int[][] dp) {
        if (sum == 0) {
            return true;
        } else if (sum < 0 || i == arr.length) {
            return false;
        } else if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        boolean found = exists(arr, i + 1, sum, dp);      // Including ith element
        if (!found) {
            found = exists(arr, i + 1, sum - arr[i], dp); // Excluding ith element
        }
        return found;
    }

    static boolean isSubsetPresentRecursive(int[] arr, int sum) {
        return exists(arr, 0, sum);
    }

    private static boolean exists(int[] arr, int i, int sum) {
        if (sum == 0) {
            return true;
        } else if (sum < 0 || i == arr.length) {
            return false;
        }
        boolean found = exists(arr, i + 1, sum);      // Including ith element
        if (!found) {
            found = exists(arr, i + 1, sum - arr[i]); // Excluding ith element
        }
        return found;
    }
}