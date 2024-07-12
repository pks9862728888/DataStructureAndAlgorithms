package com.practice.programs.revise.medium.dp.memoization.stringdp.zeroonesubsequence;

import java.util.Arrays;

public class LongestRepeatingSubsequence {

    /**
     * Find longest repeating subsequence in a string such that idx1 != idx2
     * TC: O (n * n), AS: O(n * n) + O(n) - stack space
     * Concept:
     * DP
     * STRING_DP
     * STRING_DP_LCS
     * MEMOIZATION
     * Input:
     * crivcrioo
     * lcs = crio, ans = 4
     * Input: aabb, lcs = ab, ans = 2
     */
    static int longestRepeatedSubsequence(String str) {
        int n = str.length();
        int[][] cache = new int[n][n];
        for (int[] row: cache) Arrays.fill(row, -1);
        return findLongest(str, str.length(), 0, 0, cache);
    }

    private static int findLongest(String str, int n, int idx1, int idx2, int[][] cache) {
        // Base case
        if (idx1 == n || idx2 == n) {
            return 0;
        }

        // if value does not exist in cache, then compute lcs
        if (cache[idx1][idx2] == -1) {
            // init lcs variable
            int lcs = 0;
            // if charAt(idx1) == charAt(idx2) && idx1 != idx2,
            // call f(str, idx1+1, idx2+1) + 1
            if (str.charAt(idx1) == str.charAt(idx2) && idx1 != idx2) {
                lcs = 1 + findLongest(str, n, idx1 + 1, idx2 + 1, cache);
            } else {
                // if chars don't match, then call two possibilities
                // f(str, idx1 + 1, idx2)
                lcs = Math.max(lcs, findLongest(str, n, idx1 + 1, idx2, cache));
                // f(str, idx1, idx2 + 1)
                lcs = Math.max(lcs, findLongest(str, n, idx1, idx2 + 1, cache));
            }
            cache[idx1][idx2] = lcs;
        }
        return cache[idx1][idx2];
    }
}
