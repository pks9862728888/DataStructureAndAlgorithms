package com.practice.programs.revise.medium.dp.memoization.editdistance;

import java.util.Arrays;

public class FindEditDistanceToConvertWord1ToWord2 {

    /**
     * TC: O(m * n), AS: O(m * n)
     * Concepts:
     * DP
     * EDIT_DISTANCE
     * Input:
     * horse -> ros
     * Ans: 3
     * horse -> rorse (replace 'h' with 'r')
     * rorse -> rose (remove 'r')
     * rose -> ros (remove 'e')
     */
    static int editDistance(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] cache = new int[n1][n2];
        for (int[] row: cache) Arrays.fill(row, -1);
        return editDistance(s1, s2, 0, 0, n1, n2, cache);
    }

    private static int editDistance(String s1, String s2, int idx1, int idx2, int n1, int n2, int[][] cache) {
        // Base case 1
        // When idx1 and idx2 both reached end, then return 0 indicating no more edits are required
        if (idx1 == n1 && idx2 == n2) {
            return 0;
        }

        // Base case 2
        // When idx1 reached end but idx2 did not reach end
        // We can insert chars into first word to make it equal to second
        if (idx1 == n1) {
            return n2 - idx2;
        }

        // Base case 3
        // when idx2 reached end but idx1 did not reach end
        // We can delete chars from first word to make it equal to second
        if (idx2 == n2) {
            return n1 - idx1;
        }

        if (cache[idx1][idx2] == -1) {
            // Operations (explore all possible outcomes)
            int minOperations;
            boolean charMatches = s1.charAt(idx1) == s2.charAt(idx2);
            if (charMatches) {
                // When char matches, (i + 1, j + 1)
                minOperations = editDistance(s1, s2, idx1 + 1, idx2 + 1, n1, n2, cache);
            } else {
                // When char does not matches
                // Insert char in first string to make it equal to second string char (i, j + 1)
                int insertCost = editDistance(s1, s2, idx1, idx2 + 1, n1, n2, cache);

                // Delete char from first string (i + 1, j)
                int deleteCost = editDistance(s1, s2, idx1 + 1, idx2, n1, n2, cache);

                // Replace char in first string (i + 1, j + 1)
                int replaceCost = editDistance(s1, s2, idx1 + 1, idx2 + 1, n1, n2, cache);

                minOperations = 1 + Math.min(insertCost, Math.min(deleteCost, replaceCost));
            }
            cache[idx1][idx2] = minOperations;
        }
        return cache[idx1][idx2];
    }
}
