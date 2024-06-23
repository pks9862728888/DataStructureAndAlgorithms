package com.practice.programs.revise.medium.trie;

import java.util.HashMap;
import java.util.Map;

public class FindLongestWordInDictionary {

    /**
     * TC: O(n * max(words[i].length()), AS: O(n)
     * Input:
     * a
     * banana
     * app
     * appl
     * apple
     * app
     * apply
     * Ans: apple (apply is not chosen because apple is lexicographically smaller)
     * Concept:
     * HASHING
     * TRIE
     * In place of trie, hashing can also be used, but TC will be a little worse
     */
    static String longestWordInDictionary(int n, String words[]) {
        // Add all distinct words in dictionary
        TrieNode root = null;
        for (String word : words) root = buildTrie(root, word);

        // Init longest word to empty string
        // Iterate through words and see if its present in dict, if yes check if its longest
        String longestWord = "";
        for (String word : words) {
            int wordLen = word.length();
            for (int i = 0; i < wordLen; i++) {
                String currWord = word.substring(0, i + 1);
                if (TrieNode.contains(root, currWord)) {
                    int currWordLen = currWord.length();
                    int longestWordLen = longestWord.length();
                    if (longestWordLen == 0 || currWordLen > longestWordLen) {
                        longestWord = currWord;
                    } else if (longestWordLen == currWordLen) {
                        longestWord = currWord.compareTo(longestWord) < 0 ? currWord : longestWord;
                    }
                } else {
                    break;
                }
            }
        }
        return longestWord;
    }

    private static TrieNode buildTrie(TrieNode root, String word) {
        if (root == null) {
            root = new TrieNode();
        }
        int n = word.length();
        TrieNode prev = root;
        for (int i = 0; i < n; i++) {
            char currCh = word.charAt(i);
            if (!prev.next.containsKey(currCh)) {
                prev.addNext(currCh);
            }
            prev = prev.next.get(currCh);
        }
        prev.isTerminatingNode = true;
        return root;
    }

    private static class TrieNode {
        char currChar;
        Map<Character, TrieNode> next = new HashMap<>();
        boolean isTerminatingNode;

        public TrieNode() {
            this.next = new HashMap<>();
        }

        void addNext(char ch) {
            this.next.put(ch, new TrieNode());
        }

        public static boolean contains(TrieNode root, String word) {
            TrieNode prev = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (prev.next.containsKey(ch)) {
                    prev = prev.next.get(ch);
                } else {
                    return false;
                }
            }
            return prev.isTerminatingNode;
        }
    }
}
