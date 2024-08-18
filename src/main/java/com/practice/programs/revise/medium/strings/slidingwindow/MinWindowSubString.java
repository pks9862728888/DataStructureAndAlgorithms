package com.practice.programs.revise.medium.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * TC: O(m + n) where m = len(s), n = len(t)
 * AS: O(1)
 * Concepts:
 * STRING
 * TWO_POINTER
 * SLIDING_WINDOW
 */
public class MinWindowSubString {

    public String minWindow(String s, String t) {
        // Build freq map to store window and exp freq
        Map<Character, Integer> expFreqMap = buildExpFreqMap(t);
        Map<Character, Integer> actFreqMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int leftWindowIdx = -1;
        int minWindowLen = Integer.MAX_VALUE;
        while (right < n) {
            char ch = s.charAt(right);
            if (expFreqMap.containsKey(ch)) {
                // update freq of right
                actFreqMap.put(ch, actFreqMap.getOrDefault(ch, 0) + 1);
                // while expFreqMap == actualFreqMap update minWindow and decrement left (to find min window)
                while (isValid(actFreqMap, expFreqMap) && left < n) {
                    int windowLen = right - left + 1;
                    if (windowLen < minWindowLen) {
                        minWindowLen = windowLen;
                        leftWindowIdx = left;
                    }
                    char leftCh = s.charAt(left++);
                    if (expFreqMap.containsKey(leftCh)) actFreqMap.put(leftCh, actFreqMap.get(leftCh) - 1);
                }
            }
            right++;
        }
        return leftWindowIdx == -1 ? "" : s.substring(leftWindowIdx, leftWindowIdx + minWindowLen);
    }

    private boolean isValid(Map<Character, Integer> actFreqMap, Map<Character, Integer> expFreqMap) {
        if (actFreqMap.size() != expFreqMap.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry: actFreqMap.entrySet()) {
            Character key = entry.getKey();
            if (entry.getValue() < expFreqMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> buildExpFreqMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int n = str.length();
        for (int idx = 0; idx < n; idx++) {
            char ch = str.charAt(idx);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        return freqMap;
    }
}
