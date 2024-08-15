package com.practice.programs.revise.medium.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * TC: O(n), AS: O(1)
 * Concepts:
 * STRING
 * SLIDING_WINDOW
 * TWO_POINTER
 */
public class LongestRepeatingCharacterReplacement {

    // Input: ABBBB, K = 1, ans = 5
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int right = 0;
        int left = 0;
        int n = s.length();
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int maxFreq = 0;
        while (right < n) {
            char ch = s.charAt(right);
            int currFreq = charFreqMap.getOrDefault(ch, 0) + 1;
            charFreqMap.put(ch, currFreq);
            maxFreq = Math.max(maxFreq, currFreq);
            int len = right - left + 1;
            if (len - maxFreq <= k) { // calculate no of replacements = len - maxFreq
                // If no of replacements are in allowed range
                longest = Math.max(longest, len);
            } else {
                // no of replacements exceeds threshold, so decrease the window
                char leftCh = s.charAt(left++);
                charFreqMap.put(leftCh, charFreqMap.getOrDefault(leftCh, 0) - 1);
                // no need to re-calculate maxFreq
                // because for len - maxFreq to be minimum there is no point in decreasing maxFreq
            }
            right++;
        }
        return longest;
    }
}
