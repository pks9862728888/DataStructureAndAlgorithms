package com.practice.programs.easy.arrays;

import java.util.*;

/**
 * TC: O(n2)
 */
public class TripletSum {

    public static void main(String[] args) {
        int arr[] = {0, 0, 5, 0, 5};
        int k = 5;
        System.out.println(tripletSum(arr, k));
    }

    public static int tripletSum(int[] arr, int num) {
        Arrays.sort(arr);
        int n = arr.length;
        int numTriplets = 0;
        for (int i = 0; i < n; i++) {
            int pairSumFor = num - arr[i];
            int numPairs = pairSum(arr, (i + 1), (n - 1), pairSumFor);
            numTriplets += numPairs;
        }
        return numTriplets;
    }

    private static int pairSum(int[] arr, int l, int r, int num) {
        int numPair = 0;
        while (l < r) {
            if (arr[l] + arr[r] < num) {
                l++;
            } else if (arr[l] + arr[r] > num) {
                r--;
            } else {
                int elementAtStart = arr[l];
                int elementAtEnd = arr[r];
                if (elementAtStart == elementAtEnd) {
                    int totalElementsFromStartToEnd = (r - l) + 1;
                    numPair += (totalElementsFromStartToEnd * (totalElementsFromStartToEnd - 1) / 2);
                    return numPair;
                }
                int tempStartIndex = l + 1;
                int tempEndIndex = r - 1;
                while (tempStartIndex <= tempEndIndex && arr[tempStartIndex] == elementAtStart) {
                    tempStartIndex += 1;
                }
                while (tempEndIndex >= tempStartIndex && arr[tempEndIndex] == elementAtEnd) {
                    tempEndIndex -= 1;
                }
                int totalElementsFromStart = (tempStartIndex - l);
                int totalElementsFromEnd = (r - tempEndIndex);
                numPair += (totalElementsFromStart * totalElementsFromEnd);
                l = tempStartIndex;
                r = tempEndIndex;
            }
        }
        return numPair;
    }
}
