package com.practice.programs.revise.medium.dp.memoization.boundedknapsack;

import java.util.Arrays;

/**
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
 * Pattern: BOUNDED_FRACTIONAL_KNAPSACK
 */
public class FindNoOfWaysToDecodeEncodedString {

    private static final long MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        long[] cache = new long[n];
        Arrays.fill(cache, -1);
        return (int) find(s, n, 0, cache);
    }

    private long find(String s, int n, int currIdx, long[] cache) {
        if (currIdx == n) {
            return 1;
        }
        if (cache[currIdx] == -1) {
            long waysOneLetter = canSplitByOne(s, currIdx, n) ? find(s, n, currIdx + 1, cache) : 0;
            long waysTwoLetter = canSplitByTwo(s, currIdx, n) ?
                    find(s, n, currIdx + 2, cache) : 0;
            cache[currIdx] = (waysOneLetter + waysTwoLetter) % MOD;
        }
        return cache[currIdx];
    }

    private boolean canSplitByOne(String s, int currIdx, int n) {
        return currIdx < n && s.charAt(currIdx) != '0';
    }

    private boolean canSplitByTwo(String s, int currIdx, int n) {
        if (currIdx + 1 >= n) {
            return false;
        }
        char firstLetter = s.charAt(currIdx);
        char secondLetter = s.charAt(currIdx + 1);
        return firstLetter != '0' && firstLetter <= '2' && secondLetter <= '6';
    }
}
