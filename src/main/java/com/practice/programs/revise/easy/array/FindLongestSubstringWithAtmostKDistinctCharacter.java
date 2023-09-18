package com.practice.programs.revise.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(n), AS: O(n)
 * Sliding window approach of variable window size
 */
class FindLongestSubstringWithAtmostKDistinctCharacter {

    // abacd, 3 -> abac (4)
    // Xyyzya, 3 -> yyzya (5)

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0;
        int lengthLongestSubstring = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            while (freq.size() > k) {
                char leftCh = s.charAt(left);
                freq.put(leftCh, freq.get(leftCh) - 1);
                if (freq.get(leftCh) == 0) {
                    freq.remove(leftCh);
                }
                left++;
            }
            lengthLongestSubstring = Math.max(lengthLongestSubstring, right - left + 1);
            right++;
        }
        return lengthLongestSubstring;
    }
}
