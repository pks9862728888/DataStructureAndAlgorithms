package com.practice.programs.easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(n), AS: O(n)
 */
public class FindIfStringPermutationCanFormPalindrome {

    // nnaamm -> true "naman"
    // hello -> false
    // Aab -> false

    // Property of palindrome:
    // If string length is even, then all chars have to have even frequency
    // If string length is odd, then at most 1 char can have odd frequency
    // Empty string / string of length 1 is also palindrome
    public static int isPermutationPalindrome(String s) {
        // Iterate over the elements and find count of all chars
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Find count of odd freq chars
        int oddFreqCharCount = 0;
        for (Integer c : m.values()) {
            if (c % 2 != 0) {
                oddFreqCharCount++;
            }
        }

        // If no of odd chars are <= 1 then true
        return oddFreqCharCount <= 1 ? 1 : 0;
    }
}
