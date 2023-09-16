package com.practice.programs.easy.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/longest-substring-without-repeating-characters_630418?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class LongestSubstringWithoutRepeatingChar {

    public static int uniqueSubstrings(String input) {
        // Keep counter to find length of uniqueSubstring, and map to count freq
        // Iterate over each element of input by keeping left pointer and right pointer
        // 	Store freq of char in right pointer
        // 	If freq is > 1, start incrementing left pointer till freq becomes 1
        // 	Update max length
        int maxLengthSubStr = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int left = 0, right = 0;
        while (right < input.length()) {
            char rightCh = input.charAt(right);

            // Update freq of right char
            charFreqMap.put(rightCh, charFreqMap.getOrDefault(rightCh, 0) + 1);

            // Decrement window size till freq of right char is 1
            while (charFreqMap.get(rightCh) > 1) {
                char leftCh = input.charAt(left++);
                int newFreqLeftCh = charFreqMap.get(leftCh) - 1;
                if (newFreqLeftCh > 0) {
                    charFreqMap.put(leftCh, newFreqLeftCh);
                } else {
                    charFreqMap.remove(leftCh);
                }
            }
            maxLengthSubStr = Math.max(maxLengthSubStr, right - left + 1);
            right++;
        }
        return maxLengthSubStr;
    }
}
