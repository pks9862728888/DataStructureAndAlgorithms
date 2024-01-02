package com.practice.programs.easy.string;

import java.util.HashMap;
import java.util.Map;

public class FindFirstOccurrenceOfExtraCharIdxInTwoString {

    public static int extraCharacterIndex(String str1, String str2) {
        return optimizedApproach(str1, str2); // TC: O(n + m), AS: O(1)
        // return betterApproach(str1, str2); // TC: O(n + m), AS: O(1)
    }

    private static int optimizedApproach(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return extraCharacterIndex(str2, str1);
        }
        int xorRes = getXorRes(0, str1);
        xorRes = getXorRes(xorRes, str2);
        char extraChar = (char) xorRes;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == extraChar) {
                return i;
            }
        }
        return -1;
    }

    private static int getXorRes(int currRes, String str) {
        for (int i = 0; i < str.length(); i++) {
            currRes ^= str.charAt(i);
        }
        return currRes;
    }

    private static int betterApproach(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return extraCharacterIndex(str2, str1);
        }
        Map<Character, Integer> charFreqMapStr1 = generateCharFreqMap(str1);
        Map<Character, Integer> charFreqMapStr2 = generateCharFreqMap(str2);
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (!charFreqMapStr1.getOrDefault(ch, -1).equals(charFreqMapStr2.get(ch))) {
                return i;
            }
        }
        return -1;
    }

    private static Map<Character, Integer> generateCharFreqMap(String str) {
        Map<Character, Integer> charIdxMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charIdxMap.put(ch, charIdxMap.getOrDefault(ch, 0) + 1);
        }
        return charIdxMap;
    }
}
