package com.demo.searching.recursively;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearchAlgo(arr, 2));
        System.out.println(binarySearchAlgo(arr, 9));
    }

    private static boolean binarySearchAlgo(int[] arr, int k) {
        if (arr.length == 0) {
            return false;
        }
        return binarySearchRecursively(arr, k, 0, arr.length - 1);
    }

    private static boolean binarySearchRecursively(int[] arr, int k, int st, int end) {
        if (st > end) {
            return false;
        }
        int mid = (st + end) / 2;

        if (arr[mid] == k) {
            return true;
        } else if (arr[mid] > k) {
            return binarySearchRecursively(arr, k, st, mid - 1);
        } else {
            return binarySearchRecursively(arr, k, mid + 1, end);
        }
    }
}
