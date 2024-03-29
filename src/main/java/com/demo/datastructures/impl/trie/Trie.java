package com.demo.datastructures.impl.trie;

import java.util.List;

public class Trie {

    private final Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void add(String word) {
        word = word.toLowerCase();
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node newNode = curr.children[ch - 'a'];
            if (newNode == null) {
                newNode = new Node(ch);
                curr.children[ch - 'a'] = newNode;
            }
            curr = newNode;
        }
        curr.isTerminating = true;
    }

    public boolean search(String word) {
        word = word.toLowerCase();
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.children[word.charAt(i) - 'a'];
            if (curr == null) {
                return false;
            }
        }
        return curr.isTerminating;
    }

    public void remove(String word) {
        word = word.toLowerCase();
        Node prev = root;
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            prev = curr;
            curr = curr.children[ch - 'a'];
            if (curr == null) {
                return;
            }
        }
        curr.isTerminating = false;

        // Remove the node also if its terminal
        boolean isTerminal = true;
        for (Node n : curr.children) {
            if (n != null) {
                isTerminal = false;
                break;
            }
        }
        if (isTerminal) {
            prev.children[curr.data - 'a'] = null;
        }
    }

    public int countWords() {
        int wdCount = 0;
        for (Node nd : root.children) {
            if (nd != null) {
                wdCount += countWords(nd);
            }
        }
        return wdCount;
    }

    private int countWords(Node node) {
        int wdCount = node.isTerminating ? 1 : 0;
        for (Node nd : node.children) {
            if (nd != null) {
                wdCount += countWords(nd);
            }
        }
        return wdCount;
    }

    public void addSuffixTrie(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            addSuffixTrieHelper(word.substring(i));
        }
    }

    private void addSuffixTrieHelper(String word) {
        Node prev;
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            prev = curr;
            curr = curr.children[ch - 'a'];
            if (curr == null) {
                curr = new Node(ch);
                prev.children[ch - 'a'] = curr;
            }
        }
        curr.isTerminating = true;
    }

    public boolean patternMatches(List<String> al, String pattern) {
        al.forEach(this::addSuffixTrie);
        return search(pattern);
    }

    public void printAllAutocompleteWords(List<String> input, String wd) {
        input.forEach(this::add);
        Node curr = root;

        // Find prefix
        for (int i = 0; i < wd.length(); i++) {
            char ch = wd.charAt(i);
            curr = curr.children[ch - 'a'];
            if (curr == null) {
                return;
            }
        }

        // Print all terminating nodes
        if (curr.isTerminating) {
            System.out.println(wd);
        }
        for (Node ch : curr.children) {
            if (ch != null) {
                printAllAutoCompleteWords(ch, wd);
            }
        }
    }

    private void printAllAutoCompleteWords(Node curr, String prefix) {
        prefix += curr.data;
        if (curr.isTerminating) {
            System.out.println(prefix);
        }
        for (Node ch : curr.children) {
            if (ch != null) {
                printAllAutoCompleteWords(ch, prefix);
            }
        }
    }

    static class Node {
        char data;
        boolean isTerminating;
        Node[] children;

        public Node(char data) {
            this.data = data;
            this.isTerminating = false;
            this.children = new Node[26];
        }
    }

}
