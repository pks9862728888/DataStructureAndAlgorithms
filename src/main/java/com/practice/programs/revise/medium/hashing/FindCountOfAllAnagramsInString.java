package com.practice.programs.revise.medium.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TC: O(n), AS: O(1)
 * where n = length of string s
 */
public class FindCountOfAllAnagramsInString {

    public static void main(String[] args) {
        System.out.println(findAnagrams("aaba", "ab"));  // 1, 2
        System.out.println(findAnagrams("abab", "ab"));  // 0, 1, 2
    }

    public static List<Integer> findAnagrams(String s, String p) {
        // If length of p > s -> return empty string
        // Create hash of occurrence of chars in p
        // Use sliding window of size p.length() and keep updating another hash
        // for each i + 1 >= p.length() check if hash count is matching
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> anaIdxList = new ArrayList<>();
        Map<Character, Integer> pCharMap = getMapOfChars(p);
        Map<Character, Integer> substrCharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            substrCharMap.put(ch, substrCharMap.getOrDefault(ch, 0) + 1);
            if (i >= p.length() - 1) {
                if (isAnagram(pCharMap, substrCharMap)) {
                    anaIdxList.add(i - p.length() + 1);
                }
                char prevCh = s.charAt(i - p.length() + 1);
                substrCharMap.put(prevCh, substrCharMap.get(prevCh) - 1);
                if (substrCharMap.get(prevCh) == 0) {
                    substrCharMap.remove(prevCh);
                }
            }
        }
        return anaIdxList;
    }

    private static boolean isAnagram(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            if (!entry.getValue().equals(m2.getOrDefault(entry.getKey(), -1))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getMapOfChars(String p) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }
        return m;
    }
}
