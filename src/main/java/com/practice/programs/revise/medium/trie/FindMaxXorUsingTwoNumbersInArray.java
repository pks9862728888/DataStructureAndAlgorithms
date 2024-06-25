package com.practice.programs.revise.medium.trie;

import java.util.List;

public class FindMaxXorUsingTwoNumbersInArray {

    /**
     * Find max xor between two numbers, bits are 32 bit
     * TC: n log MAX_BIT_SIZE
     * AS: n * MAX_BIT_SIZE
     * Input: 1, 3, 9, ans = 10
     * Xor between 3 & 9 is max = 10
     * Intuition:
     * To maximize XOR we need to find a number such that MSB is opposite to the no we are xoring with.
     * So trie will come into rescue
     * Concepts:
     * TRIE
     * BIT_MANIPULATION
     */
    public static int maximumXor(int n, List<Integer> nums) {
        // build trie n log 32
        Trie trie = new Trie();
        for (int no: nums) {
            trie.insert(no);
        }

        // Get max XOR, n log 32
        int maxXor = 0;
        for (int no: nums) {
            maxXor = Math.max(maxXor, trie.getMaxXor(no));
        }
        return maxXor;
    }

    private static class Trie {
        public TrieNode trie;
        private static final int NUM_SIZE = 30;
        public Trie() {
            this.trie = new TrieNode();
        }
        public void insert(int no) {
            TrieNode curr = trie;
            for (int i = NUM_SIZE; i >= 0; i--) {
                int bit = (no >> i) & 1;
                if (!curr.contains(bit)) {
                    curr.add(bit);
                }
                curr = curr.get(bit);
            }
        }
        public int getMaxXor(int no) {
            TrieNode curr = trie;
            int maxNo = 0;
            for (int i = NUM_SIZE; i >= 0; i--) {
                int bit = (no >> i) & 1;
                if (curr.contains(1 - bit)) {
                    // opposite bit is present, so make bit opposite
                    maxNo = maxNo | (1 << i);
                    curr = curr.get(1 - bit);
                } else {
                    curr = curr.get(bit);
                }
            }
            return maxNo;
        }
    }

    public static class TrieNode {
        TrieNode[] bits;
        public TrieNode() {
            this.bits = new TrieNode[2];
        }
        public void add(int bit) {
            bits[bit] = new TrieNode();
        }
        public boolean contains(int bit) {
            return get(bit) != null;
        }
        public TrieNode get(int bit) {
            return bits[bit];
        }
    }
}
