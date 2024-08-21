package com.practice.programs.revise.medium.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://bit.ly/3qwT4OL
 * Concepts:
 * TRIE
 */
public class ImplementTrie {

    private TrieNode trie;

    public ImplementTrie() {
        trie = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode curr = trie;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            curr = curr.getOrCreateChild(ch);
        }
        curr.end = true;
        curr.freq++;
    }

    public int countWordsEqualTo(String word) {
        int count = 0;
        int n = word.length();
        TrieNode curr = trie;
        for (int i = 0; i < n && curr != null; i++) {
            char ch = word.charAt(i);
            curr = curr.getChild(ch);
            if (i == n - 1 && curr != null && curr.end) {
                count = curr.freq;
            }
        }
        return count;
    }

    public int countWordsStartingWith(String word) {
        int n = word.length();
        int count = 0;
        TrieNode curr = trie;
        for (int i = 0; i < n && curr != null; i++) {
            char ch = word.charAt(i);
            curr = curr.getChild(ch);
            if (i == n - 1 && curr != null) {
                count = getEowCount(curr);
            }
        }
        return count;
    }

    private int getEowCount(TrieNode curr) {
        int count = 0;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(curr);
        while (!q.isEmpty()) {
            curr = q.poll();
            if (curr.end) {
                count += curr.freq;
            }
            q.addAll(curr.charMap.values());
        }
        return count;
    }

    public void erase(String word) {
        int n = word.length();
        TrieNode curr = trie;
        for (int i = 0; i < n && curr != null; i++) {
            char ch = word.charAt(i);
            curr = curr.getChild(ch);
            if (i == n - 1 && curr != null && curr.end) {
                curr.freq--;
            }
        }
    }

    private static class TrieNode {
        Map<Character, TrieNode> charMap = new HashMap<>();
        boolean end;
        int freq;

        public TrieNode() {}

        public TrieNode getChild(Character ch) {
            return charMap.get(ch);
        }

        public TrieNode getOrCreateChild(Character ch) {
            TrieNode trieNode = getChild(ch);
            if (trieNode == null) {
                trieNode = new TrieNode();
                charMap.put(ch, trieNode);
            }
            return trieNode;
        }
    }
}
