package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.*;

public class ReorganizeStringSuchThatNoTwoSameCharsAppearTogether {

    /**
     * TC: O(n log c) where c is no of distinct chars, so log c can be treated as constant,
     * So TC becomes O(n)
     * AS: O(n) for storing result
     */
    public static String reorganizeString(String str) {
        PriorityQueue<Pair> pq = buildHeap(str);
        Queue<Pair> q = new LinkedList<>();
        StringBuilder reOrganizedStr = new StringBuilder();
        Character prev = null;
        while (!pq.isEmpty()) {
            Optional<Pair> pairOpt = findPairNotEqualToPrev(prev, pq, q);
            if (!pairOpt.isPresent()) {
                return "";
            }
            Pair pair = pairOpt.get();
            reOrganizedStr.append(pair.ch);
            prev = pair.ch;
            pair.decrementFreq();
            if (pair.freq > 0) {
                pq.add(pair);
            }
            addToPQ(pq, q);
        }

        return reOrganizedStr.toString();
    }

    private static void addToPQ(PriorityQueue<Pair> pq, Queue<Pair> q) {
        while (!q.isEmpty()) {
            pq.add(q.poll());
        }
    }

    private static Optional<Pair> findPairNotEqualToPrev(
            Character prev, PriorityQueue<Pair> pq, Queue<Pair> q) {
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (prev == null || !prev.equals(pair.ch)) {
                return Optional.of(pair);
            }
            q.add(pair);
        }
        return Optional.empty();
    }

    private static PriorityQueue<Pair> buildHeap(String str) {
        Map<Character, Integer> freqMap = buildFreqMap(str);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry: freqMap.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        return pq;
    }

    private static Map<Character, Integer> buildFreqMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        return freqMap;
    }

    private static class Pair implements Comparable<Pair> {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public void decrementFreq() {
            this.freq--;
        }

        @Override
        public int compareTo(Pair o) {
            return -1 * Integer.compare(freq, o.freq);
        }
    }
}
