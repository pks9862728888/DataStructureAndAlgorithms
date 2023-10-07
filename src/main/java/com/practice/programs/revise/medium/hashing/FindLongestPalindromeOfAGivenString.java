package com.practice.programs.revise.medium.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(n), AS: O(1)
 */
public class FindLongestPalindromeOfAGivenString {

    // 95
    //vjwbHfcjUiqpLHkbnSHgJlkzKfQaedmGHtnYZECYPrBqKJNphjIDmMOuawhoaxocTFGMiASPbkRdCKAcedpJSmhVtwngiIM

    public static void main(String[] args) {
//        System.out.println(longestPalindrome(6, "bbbccc")); // 5
        System.out.println(longestPalindrome(95, "vjwbHfcjUiqpLHkbnSHgJlkzKfQaedmGHtnYZECYPrBqKJNphjIDmMOuawhoaxocTFGMiASPbkRdCKAcedpJSmhVtwngiIM")); // 61
    }

    static int longestPalindrome(int n, String s) {
        // find count of all chars
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        // res = sum (even freq char count + max odd freq char + even count of rest odd freq char)
        int evenFreqCount = 0;
        int maxOddFreq = 0;
        char maxOddFreqChar = ' ';
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 != 0) { // odd freq
                if (entry.getValue() > maxOddFreq) {
                    maxOddFreq = entry.getValue();
                    maxOddFreqChar = entry.getKey();
                }
            } else { // even freq
                evenFreqCount += entry.getValue();
            }
        }
        if (maxOddFreq == 1) {
            return evenFreqCount + 1;
        } else if (maxOddFreq > 1) {
            int evenCountOfOddFreqChars = 0;
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                if (!entry.getKey().equals(maxOddFreqChar) && entry.getValue() % 2 != 0) {
                    evenCountOfOddFreqChars += (entry.getValue() == 1 ? 0 : entry.getValue() - 1);
                }
            }
            return evenFreqCount + maxOddFreq + evenCountOfOddFreqChars;
        } else {
            return evenFreqCount;
        }
    }
}
