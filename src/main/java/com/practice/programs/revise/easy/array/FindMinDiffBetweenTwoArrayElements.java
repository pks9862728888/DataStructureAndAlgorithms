package com.practice.programs.revise.easy.array;

import java.util.Arrays;

/**
 * TC: O(n log n) + O (n) = O(n log n), AS: O(n)
 */
class FindMinDiffBetweenTwoArrayElements {

    static int minDiff(int n, int a[]) {
        Arrays.sort(a);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] < minDiff) {
                minDiff = a[i] - a[i - 1];
            }
        }
        return minDiff;
    }
}
