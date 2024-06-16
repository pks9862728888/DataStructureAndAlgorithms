package com.practice.programs.revise.medium.greedyalgorithms.fixmidpointer;

public class FindLargestPalindromicSubstringLength {

    /**
     * TC: O(n * n), AS: O(1)
     * Input: abcpca, ans = 3, cpc
     * We fix mid pointer and go left and right
     * Concept:
     * GREEDY_ALGORITHM
     * FIX_MID_POINTER_N_INCREMENT_OR_DECREMENT_RIGHT_OR_LEFT_POINTER_APPROACH
     */
    static int longestPalindromicSubstringLength(String str) {
        int largestPalindrome = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            largestPalindrome = Math.max(largestPalindrome, findLargestPalindrome(str, i, i, n));
            largestPalindrome = Math.max(largestPalindrome, findLargestPalindrome(str, i, i + 1, n));
        }
        return largestPalindrome;
    }

    private static int findLargestPalindrome(String str, int left, int right, int n) {
        if (left < 0 || right >= n) {
            return 0;
        }
        while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        // r - l + 1, here actual r = r - 1, actual l = l + 1
        return right - left - 1;
    }
}
