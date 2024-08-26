package com.practice.programs.revise.medium.dp.memoization.zeroonesubsequence;

import java.util.Arrays;

/**
 * Subsequence traversal: Left -> Right only
 * TC: O(m + n), AS: O(m + n) (cache) + O(max(m, n)) (stack space)
 * Can skip one or more characters
 * Concept:
 * MEMOIZATION
 * UNBOUNDED_ZERO_ONE_KNAPSACK
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] cache = new int[len1][len2];
        for (int[] row : cache) Arrays.fill(row, -1);
        return findLcs(s1, s2, 0, 0, len1, len2, cache);
    }

    private int findLcs(String s1, String s2, int idx1, int idx2, int len1, int len2, int[][] cache) {
        if (idx1 == len1 || idx2 == len2) {
            return 0;
        }
        if (cache[idx1][idx2] == -1) {
            int lcs = 0;
            if (s1.charAt(idx1) == s2.charAt(idx2)) { // both are same
                lcs = 1 + findLcs(s1, s2, idx1 + 1, idx2 + 1, len1, len2, cache);
            } else {
                // Increment first
                lcs = Math.max(lcs, findLcs(s1, s2, idx1 + 1, idx2, len1, len2, cache));
                // Increment second
                lcs = Math.max(lcs, findLcs(s1, s2, idx1, idx2 + 1, len1, len2, cache));
            }
            cache[idx1][idx2] = lcs;
        }
        return cache[idx1][idx2];
    }
}