package com.practice.programs.revise.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(n) AS: O(n)
 * Sliding window of variable size
 */
class FindLongestSubstringWithoutRepeatingCharacter {

    // aabcccbcb -> abc -> 3
    // cdddddd -> cd -> 2

    /**
     * Keep left and right pointer
     *    Iterate over the string and keep track of frequency of the elements in the window
     *      While freq of right ch > 1, decrease window length (leftPointer++), and update frequency
     *      Update maxChar length
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0;
        int longestSubstringLength = 1;
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            freq.put(rightCh, freq.getOrDefault(rightCh, 0) + 1);
            while (freq.get(rightCh) > 1) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            }
            longestSubstringLength = Math.max(longestSubstringLength, right - left + 1);
            right++;
        }
        return longestSubstringLength;
    }
}
