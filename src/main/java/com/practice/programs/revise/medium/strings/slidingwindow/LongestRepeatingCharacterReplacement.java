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
      while (len - maxFreq > k) {
        // no of replacements exceeds threshold, so decrease the window
        char leftCh = s.charAt(left++);
        charFreqMap.put(leftCh, charFreqMap.getOrDefault(leftCh, 0) - 1);
      }
      longest = Math.max(longest, right - left + 1);
      right++;
    }
    return longest;
  }
}
