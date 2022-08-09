package com.demo.dp;

public class SubsetSumEqualToKPresent {

    /**
     * You are given a set of N integers.
     * You have to return true if there exists a subset that sum up to K, otherwise return false.
     */
    public static void main(String[] args) {
        System.out.println(isSubsetPresentRecursive(new int[] {4, 2, 5, 6, 7}, 14));
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