package com.practice.programs.revise.medium.strings.twopointer;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 * Concepts:
 * DP
 * MEMOIZATION
 * STRING_DP
 * TWO_POINTER
 */
public class AllPalindromicSubstring {

    public int countSubstrings(String s) {
        // return bruteForce(s);
        return dpTabulation(s);
    }

    /**
     * TC: O(n^2) AS: O(n^2)
     */
    private int dpTabulation(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int gap = 0; gap < n; gap++) {
            for(int i = 0, j = i + gap; j < n; i++, j++) {
                if (gap == 0) { // mid diagonal
                    dp[i][j] = true;
                } else if (gap == 1) { // first diagonal after mid
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else { // for rest currCh should be same and previous should be equal
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TC: O(n^3) AS: O(1)
     */
    public int bruteForce(String s) {
        int left = 0;
        int n = s.length();
        int count = 0;
        while (left < n) {
            int right = left;
            while (right < n) {
                if (isPalindrome(s, left, right)) {
                    count++;
                }
                right++;
            }
            left++;
        }
        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }
}
