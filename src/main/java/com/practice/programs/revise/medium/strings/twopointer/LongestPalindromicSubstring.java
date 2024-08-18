package com.practice.programs.revise.medium.strings.twopointer;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * TC: O(n^2) AS: O(n)
 * Concepts:
 * STRING
 * TWO_POINTER
 * FIX_MID_POINTER_N_INCREMENT_OR_DECREMENT_RIGHT_OR_LEFT_POINTER_APPROACH
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        String longestPalindrome = "";
        for (int i = 0; i < n; i++) {
            // Check odd length palindrome
            int left = i;
            int right = i;
            longestPalindrome = findLongestPalindrome(s, left, right, n, longestPalindrome);
            // Check even length palindrome
            left = i;
            right = i + 1;
            longestPalindrome = findLongestPalindrome(s, left, right, n, longestPalindrome);
        }
        return longestPalindrome;
    }

    private String findLongestPalindrome(String s, int left, int right, int n, String longestPalindrome) {
        int lenLongestPalindrome = longestPalindrome.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            int palindromeLen = right - left + 1;
            if (palindromeLen > lenLongestPalindrome) {
                lenLongestPalindrome = palindromeLen;
                longestPalindrome = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
        return longestPalindrome;
    }
}
