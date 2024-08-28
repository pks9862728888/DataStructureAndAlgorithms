package com.practice.programs.revise.medium.dp.memoization.stringdp.breakpatterndp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/description/
 * TC: O(n^2) - for while loop and subString
 * AS: O(n) - for cache
 * Concept:
 * DP
 * STRING_DP
 * WORD_BREAK_PATTERN_STRING_DP
 */
public class WordBreakI {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int strLen = s.length();
        int[] cache = new int[strLen];
        Arrays.fill(cache, -1);
        return canBreak(s, 0, 0, strLen, wordSet, cache);
    }

    private boolean canBreak(String s, int st, int end, int strLen, Set<String> wordSet, int[] cache) {
        if (end >= strLen) return true;
        if (cache[st] == -1) {
            boolean canBreak = false;
            while (end < strLen && !canBreak) {
                String wd = s.substring(st, end + 1);
                if (wordSet.contains(wd)) {
                    // If word is present check if breaking here results in values from other section
                    canBreak = canBreak(s, end + 1, end + 1, strLen, wordSet, cache);
                }
                end++;
            }
            cache[st] = canBreak ? 1 : 0;
        }
        return cache[st] == 1;
    }
}
