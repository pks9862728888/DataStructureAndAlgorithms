package com.practice.programs.revise.easy.array;

import java.util.*;

/**
 * TC: O(nm log m) AS: O(mn), where n = no of words, m = length of each word
 * For each word, sorting will be done, sorting TC: m log(m)
 */
class GroupAnagramTogether {

    // eat tea tan ate nat bat
    // O/P (can be in any order):
    // ate eat tea
    // nat tan
    // bat

    public List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> freqMap = new HashMap<>();
        for (String word: strs) {
            addToHash(word, freqMap);
        }
        return new ArrayList<>(freqMap.values());
    }

    private void addToHash(String word, Map<String, List<String>> freqMap) {
        String key = generateHash(word);
        if (!freqMap.containsKey(key)) {
            freqMap.put(key, new ArrayList<>());
        }
        freqMap.get(key).add(word);
    }

    // TC: m log m -> where m = no of chars in word
    private String generateHash(String word) {
        Map<Character, Integer> m = new TreeMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }
        return m.toString();
    }
}
