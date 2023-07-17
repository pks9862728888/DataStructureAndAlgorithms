package com.demo.datastructures.impl.trie;

import java.util.Arrays;
import java.util.List;

public class TrieDemo {

    public static void main(String[] args) {
        Trie ob = new Trie();
        ob.add("Hello");
        ob.add("Hell");
        System.out.println("COUNT: " + ob.countWords());
        System.out.println("Hello ? " + ob.search("Hello"));
        System.out.println("Hell ? " + ob.search("Hell"));
        System.out.println("He ? " + ob.search("He"));
        ob.remove("Hell");
        System.out.println("Removed Hell");
        System.out.println("Hell ? " + ob.search("Hell"));
        System.out.println("COUNT: " + ob.countWords());

        Trie nt = new Trie();
        System.out.println("Pattern matches: ow? " +
                nt.patternMatches(Arrays.asList("What", "Whome", "How"), "ow"));

        Trie ac = new Trie();
        System.out.println("Printing all autocomplete words: no");
        ac.printAllAutocompleteWords(Arrays.asList("do", "dont", "no", "not", "note", "notes", "den"),
                "no");
    }
}
