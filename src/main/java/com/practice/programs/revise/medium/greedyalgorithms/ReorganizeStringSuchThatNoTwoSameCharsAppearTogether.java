package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * TC: O(n log c) where c is no of distinct chars, so log c can be treated as constant,
 * So TC becomes O(n)
 * AS: O(n) for storing result
 * https://www.educative.io/module/page/AQxxQoOnN1ASnDDZ7pzz6n/5864882417434624/4758112332546048/4712250537541632
 * Concept:
 * HEAP
 * MAX_HEAP
 */
public class ReorganizeStringSuchThatNoTwoSameCharsAppearTogether {

    public static String reorganizeString(String str) {
        if (str.isEmpty()) return str;

        // Create PQ (max-heap) to store chars with max frequency and build heap
        PriorityQueue<Pair> maxHeap = buildFreqMapInPriorityQueue(str);

        // Create sb to store result, but delay insertion
        StringBuilder resSb = new StringBuilder();
        Pair prevPair = null;
        while (!maxHeap.isEmpty() || prevPair != null) {
            // Base case
            if (prevPair != null && maxHeap.isEmpty()) {
                resSb.setLength(0);
                break;
            }
            // Pop next max freq char and add to result
            Pair currPair = maxHeap.poll();
            resSb.append(currPair.ch);

            // Add prev max freq char
            if (prevPair != null) maxHeap.add(prevPair);

            // Decrement curr pair freq but don't add it yet
            currPair.freq--;
            prevPair = currPair.freq > 0 ? currPair : null;
        }

        // Return string result
        return resSb.toString();
    }

    private static PriorityQueue<Pair> buildFreqMapInPriorityQueue(String str) {
        Map<Character, Integer> freqMap = getCharFreqMap(str);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> -1 * Integer.compare(a.freq, b.freq));
        freqMap.forEach((key, value) -> maxHeap.add(new Pair(key, value)));
        return maxHeap;
    }

    private static Map<Character, Integer> getCharFreqMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int strLen = str.length();
        for (int idx = 0; idx < strLen; idx++) {
            Character ch = str.charAt(idx);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        return freqMap;
    }

    private static class Pair {
        Character ch;
        int freq;

        public Pair(Character ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}
