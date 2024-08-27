package com.practice.programs.revise.medium.dp.memoization.boundedknapsack;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-ways/description/
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * Since the answer can be very large, print the answer modulo 1000000007.
 * Input:
 * 157 - > 2, AEG (since A is 1, E is 5 and G is 7) or OG (since O is 15 and G is 7)
 * 0 -> 0
 * TC: O(n)
 * AS: O(n)
 * Pattern:
 * DP
 * STRING_DP
 * STRING_DP_WAYS_DECODE
 * BOUNDED_ZERO_ONE_KNAPSACK
 */
public class FindNoOfWaysToDecodeEncodedString {

    public int numDecodings(String s) {
        int strLen = s.length();
        int[] cache = new int[strLen];
        Arrays.fill(cache, -1);
        return numDecodings(s, 0, strLen, cache);
    }

    private int numDecodings(String s, int idx, int n, int[] cache) {
        if (idx == n) {
            return 1;
        }
        if (cache[idx] == -1) {
            int splitBy1 = canSplitBy1(s, idx, n) ? numDecodings(s, idx + 1, n, cache) : 0;
            int splitBy2 = canSplitBy2(s, idx, n) ? numDecodings(s, idx + 2, n, cache) : 0;
            cache[idx] = splitBy1 + splitBy2;
        }
        return cache[idx];
    }

    private boolean canSplitBy1(String s, int idx, int n) {
        return idx < n && s.charAt(idx) != '0';
    }

    private boolean canSplitBy2(String s, int idx, int n) {
        if (idx + 1 >= n) {
            return false;
        }
        char firstChar = s.charAt(idx);
        char secChar = s.charAt(idx + 1);
        return firstChar == '1' || firstChar == '2' && secChar <= '6';
    }
}
