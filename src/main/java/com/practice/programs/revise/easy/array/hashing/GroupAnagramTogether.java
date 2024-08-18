package com.practice.programs.revise.easy.array.hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 * TC: O(mn) AS: O(mn), where n = no of words, m = length of each word
 * For each word, hash will be generated which is O(m)
 * Concepts:
 * STRING
 * HASHING
 */
class GroupAnagramTogether {

    // eat tea tan ate nat bat
    // O/P (can be in any order):
    // ate eat tea
    // nat tan
    // bat

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagramMap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s: strs) {
            Map<Character, Integer> freqMap = getFreqMap(s);
            if (!anagramMap.containsKey(freqMap)) {
                List<String> anagramList = new ArrayList<>();
                res.add(anagramList);
                anagramMap.put(freqMap, anagramList);
            }
            anagramMap.get(freqMap).add(s);
        }
        return res;
    }

    private Map<Character, Integer> getFreqMap(String s) {
        Map<Character, Integer> fm = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            fm.put(ch, fm.getOrDefault(ch, 0) + 1);
        }
        return fm;
    }
}
