package com.practice.programs.easy.twopointer;

/**
 * TC: O(n), AS: O(1)
 */
public class RemoveDuplicateElementsSuchThatEachElementOccursAtMostTwice {

    // 2 2 2 3 4 4 9 -> 2 2 3 4 4 9 (6)

    static int removeDuplicatesFromSortedArrayII(int n, int[] arr) {
        // Keep a pointer pointed to 1st ele, and freq = 1 and prev = arr[0]
        // Iterate over from 1 to n - 1
        // If curr == prev, freq++
        //    If freq == 2, do not do anything
        //    If freq < 2, then put arr[++pointer] = currEle
        // If currr != prev, freq = 1, prev = curr, arr[++pointer] = curr
        int frontIdx = 0;
        int prev = arr[0];
        int freq = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == prev) {
                freq++;
            } else {
                freq = 1;
                prev = arr[i];
            }
            if (freq <= 2) {
                arr[++frontIdx] = arr[i];
            }
        }
        return frontIdx + 1;
    }

}
